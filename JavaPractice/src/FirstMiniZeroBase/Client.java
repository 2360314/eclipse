package FirstMiniZeroBase;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.*;
import java.net.Socket;


public class Client extends JFrame {
    private JPanel enterPane; // 전체틀 생성
    private JTextField textField; // 닉네임 읽어오는 텍스트 필드
    private JButton enterButton; // 입력 버튼
    private String name; // 닉네임

    public Client() {
        enterPanel(); // 전체틀 생성
        nickNameLabel(); // 닉네임 입력 라벨, 텍스트 필드 생성
        enterButtonEvent(); // 입장 버튼 생성 및 처리
        setVisible(true); // Gui 켜기

    }

    public void enterPanel() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 창 종료시 프로세스 종료시키는 코드
        setBounds(100, 100, 450, 300); // 패널 사이즈 코드
        enterPane = new JPanel();
        enterPane.setBackground(new Color(255, 255, 255));
        setContentPane(enterPane);
        enterPane.setLayout(null);
    }

    public void nickNameLabel() {
        JLabel nickName = new JLabel("닉네임 입력");
        nickName.setBounds(180, 60, 80, 15);
        enterPane.add(nickName);

        textField = new JTextField();
        textField.setBounds(155, 75, 115, 20);
        enterPane.add(textField);
        textField.setColumns(10); // 글자수 제한
    }


    public void enterButtonEvent() {
        enterButton = new JButton("입장");
        enterButton.addActionListener(new ActionListener() {
            // 입장 버튼 클릭시 이벤트 처리
            public void actionPerformed(ActionEvent e) {
                sendToChatGui();
            }
        });
        enterButton.setBounds(165, 134, 97, 23);
        enterPane.add(enterButton);

        // 엔터 입력시 입장 처리
        textField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }
            @Override
            public void keyPressed(KeyEvent e) {
                // 엔터키 입력시 이벤트 처리
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    sendToChatGui();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
    }

    public void sendToChatGui() {
        name = textField.getText(); // 닉네임 name 읽어오기
        setVisible(false); // EnterGui 창 끄기
        new ChatGui(name); // ChatGui에 닉네임 name 값 전달
    }
}




 class ChatGui extends JFrame {

    private JPanel chatPanel;
    private JTextField textMsg;
    private TextArea chatLog;
    private BufferedReader reader;
    public PrintWriter writer;

    //ChatGui 구현
    public ChatGui(String id) {
        // EnterGui에서 보내는 닉네임 값을 매개변수로 받음
        String msg = "login/" + id;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 550, 500);
        chatPanel = new JPanel();
        chatPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(chatPanel);
        chatPanel.setBackground(new Color(255, 255, 255));
        chatPanel.setLayout(null);

        // chatLabel과 chatLog
        JLabel chatLabel = new JLabel("채팅방"); // chatLabel 생성
        chatLabel.setBounds(240, 10, 95, 15);
        chatPanel.add(chatLabel);

        chatLog = new TextArea(); // chatLog 생성
        chatLog.setEditable(false);
        chatLog.setText("채팅 로그입니다.");
        chatLog.setBounds(18, 25, 500, 400);
        chatPanel.add(chatLog);

        textMsg = new JTextField();
        textMsg.setText("메세지를 입력하세요");
        textMsg.setBounds(18, 430, 500, 20);
        chatPanel.add(textMsg);
        textMsg.setColumns(10);

//        메세지 전송 엔터키 이벤트 처리
        textMsg.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    //엔터키 눌렸을때 실행될 코드
                    String text = textMsg.getText();
                    writer.println(text);// 텍스트를 서버로 전송
                    textMsg.setText(""); // 텍스트 필드의 값 지움 => 초기화
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        setVisible(true);
        try {
            // 소켓통신으로 서버로 메세지 전송하는 코드
            // 서버 정보
            String serverIP = "localhost";
            int serverPort = 8888; // 서버 포트 번호

            // 서버에 연결
            Socket socket = new Socket(serverIP, serverPort);
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // 서버로부터 메시지를 읽는 스레드 시작
            Thread readThread = new Thread(new ServerMessageReader());
            readThread.start();

            // 서버로 메세지 전송
            OutputStream outputStream = socket.getOutputStream();
            writer = new PrintWriter(outputStream, true);
            writer.println(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //서버에서 주는 메세지 처리
    private class ServerMessageReader implements Runnable {
        @Override
        public void run() {
            try {
                String message;
                while ((message = reader.readLine()) != null) {
                    System.out.println("서버로부터 메시지: " + message);
                    uploadText(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //받은 메세지 채팅창에 업로드
    public void uploadText(String message) {
        chatLog.append(message + "\n");
    }
}

