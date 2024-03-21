package d240316;

class Tv{
	boolean power;
	int channel;
	
	void power() {
		power =! power;
	}
	
	void channelUp() {++channel;}
	void channedlDown() {++channel;}

}

class VCR{
	boolean power;
	int counter = 0;
	void power() {power=!power;}
	void play() {}
	void stop() {}
	void rew() {}
	void ff() {}
	
}


public class TVCR_7_4 extends Tv{

	VCR vcr = new VCR();
	void play() {vcr.play();}
	void stop() {vcr.stop();}
	void rew() {vcr.rew();}
	void ff() {vcr.ff();}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
