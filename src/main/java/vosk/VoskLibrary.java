package vosk;

import org.vosk.Model;
import org.vosk.Recognizer;
import org.vosk.LibVosk;
import org.vosk.LogLevel;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.TargetDataLine;
import java.io.IOException;

public class VoskLibrary {
    private final Model model;

    public Model getModel() {
        return model;
    }

    private void handleCommand(String text) {
        System.out.println("Command: " + text);
    }

    public VoskLibrary(String modelPath) {
        try {
            LibVosk.setLogLevel(LogLevel.INFO);
            this.model = new Model(modelPath);
        } catch (IOException e) {
            throw new RuntimeException("Failed to find vosk model from: " + modelPath, e);
        }
    }

    public String recognize() {
        AudioFormat format = new AudioFormat(16000, 16, 1, true, false);
        String finalText = "";

        try (Recognizer recognizer = new Recognizer(model, 16000)) {
            TargetDataLine mic = AudioSystem.getTargetDataLine(format);
            mic.open(format);
            mic.start();

            byte[] buffer = new byte[4096];

            long startTime = System.currentTimeMillis();
            while (System.currentTimeMillis() - startTime < 20000) {
                int bytesRead = mic.read(buffer, 0, buffer.length);
                if (recognizer.acceptWaveForm(buffer, bytesRead)) {
                    finalText = recognizer.getResult().trim();
                    handleCommand(finalText);
                    return finalText;
                }
            }

            mic.stop();
            mic.close();

        } catch (LineUnavailableException e) {
            return "error: mic unavailable";
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return "error";
        }


        return "no command detected";
    }
}
