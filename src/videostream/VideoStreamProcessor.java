package videostream;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.highgui.HighGui;
import org.opencv.imgproc.Imgproc;
import org.opencv.videoio.VideoCapture;

public class VideoStreamProcessor {

    static { System.loadLibrary(Core.NATIVE_LIBRARY_NAME); }

    public static void main(String[] args) {
        VideoCapture capture = new VideoCapture(0); // 0 is the default camera

        if (!capture.isOpened()) {
            System.out.println("Error: Camera not detected.");
            return;
        }

        Mat frame = new Mat();
        while (true) {
            capture.read(frame);
            if (frame.empty()) {
                System.out.println("No video frame captured.");
                break;
            }

            // Perform processing (e.g., object detection, facial recognition) here

            // Show the processed frame
            HighGui.imshow("Video Stream", frame);
            if (HighGui.waitKey(30) >= 0) {
                break; // Exit if any key is pressed
            }
        }
        capture.release();
        HighGui.destroyAllWindows();
    }
}

