package New;

interface CallFeature {
	void call();
}

interface CameraFeature {
	void takePhoto();
}

interface MusicFeature {
	void playMusic();
}

class BasicPhone implements CallFeature {
	
	public void call() {
		System.out.println("Basic phone calling....");
	}
}

class SmartPhone implements CallFeature , CameraFeature , MusicFeature {
	
	public void call() {
		System.out.println("Smart phone calling....");
	}
	
	public void takePhoto() {
		System.out.println("Taking a photo ....");
	}
	
	public void playMusic() {
		System.out.println("Playing music...");
	}
}

public class ISP {
	public static void main (String[] args ) {
		
		BasicPhone phone1 = new BasicPhone();
		phone1.call();
		
		SmartPhone phone2 = new SmartPhone();
		phone2.call();
		phone2.takePhoto();
		phone2.playMusic();
	}
}