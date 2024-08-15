package videostream;

import org.opencv.core.Core;

import org.opencv.core.Mat;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.osgi.OpenCVInterface;
import org.opencv.videoio.VideoCapture;

public class VideoCap {
	public static void main(String[] args) {
		int i=1;
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME); 
		VideoCapture camera = new VideoCapture(0);
		
		if (!camera.isOpened()) {
		    System.out.println("Error: Camera not opened");
		} else {
		    Mat frame = new Mat();

		    while (true) {
		    	
		        if (camera.read(frame)) {
		            System.out.println("Frame Obtained");
		            System.out.println("Captured Frame Width: " + frame.width() + " Height: " + frame.height());
		            Imgcodecs.imwrite("C:\\Users\\gadak\\Pictures\\Saved Pictures/camera"+i+".jpg", frame);
		            System.out.println("Image saved successfully");
		            break;
		        }
		        i++;
		    }
		}

		camera.release();
    }

}