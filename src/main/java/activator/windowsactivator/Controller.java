package activator.windowsactivator;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

import javafx.scene.text.Text;
import org.tinylog.Logger;

public class Controller {

    @FXML
    public Text winvertext;

    @FXML
    public void initialize() throws IOException {
        setWindowsVersionText();
    }

    private final Map<String,String> keyMap = Map.of(
            "Home", "TX9XD-98N7V-6WMQ6-BX7FG-H8Q99",
            "Home N", "3KHY7-WNT83-DGQKR-F7HPR-844BM",
            "Professional" , "W269N-WFGWX-YVC9B-4J6C9-T83GX",
            "Professional N" , "MH37W-N47XK-V7XM9-C7227-GCQG9",
            "Education", "NW6C2-QMPVW-D7KKK-3GKT6-VCFB2",
            "Education N", "2WH4N-8QGBV-H22JP-CT43Q-MDWWJ",
            "Enterprise", "NPPR9-FWDCX-D2C8J-H872K-2YT43",
            "Enterprise N", "DPH2V-TTNVB-4X9Q3-TJR4H-KHJW4"
    );

    private void runCommand(String com) throws IOException, InterruptedException {
        String command;

        switch(com){
            case "Home":
                command = "cmd.exe /c slmgr /ipk " + keyMap.get(com);
                break;
            case "Home N":
                command = "cmd.exe /c slmgr /ipk " + keyMap.get(com);
                break;
            case "Professional":
                command = "cmd.exe /c slmgr /ipk " + keyMap.get(com);
                break;
            case "Professional N":
                command = "cmd.exe /c slmgr /ipk " + keyMap.get(com);
                break;
            case "Education":
                command = "cmd.exe /c slmgr /ipk " + keyMap.get(com);
                break;
            case "Education N":
                command = "cmd.exe /c slmgr /ipk " + keyMap.get(com);
                break;
            case "Enterprise":
                command = "cmd.exe /c slmgr /ipk " + keyMap.get(com);
                break;
            case "Enterprise N":
                command = "cmd.exe /c slmgr /ipk " + keyMap.get(com);
                break;
            default:
                command = "cmd.exe /c " + com;
        }

        Logger.info("Starting to process: " + com);
        ProcessBuilder processBuilder = new ProcessBuilder(command.split(" "));
        Process process = processBuilder.start();

        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }

        int exitCode = process.waitFor();

        if(exitCode == 0){
            if (command.contains("ipk")) {
                Logger.info("Product key installed successfully!");
            } else if (command.contains("kms")) {
                Logger.info("KMS Server set successfully!");
            } else if (command.contains("ato")) {
                Logger.info("Windows activated successfully!");
            } else if (command.contains("upk")) {
                Logger.info("Windows deactivated successfully!");
            }
        } else {
            Logger.info("Something went wrong...");
        }
    }

    @FXML
    public void setWindowsVersionText() throws IOException {
        String winVersion;
        String command = "cmd.exe /c systeminfo | findstr /C:\"OS Name\" ";
        ProcessBuilder processBuilder = new ProcessBuilder(command.split(" "));
        Process process = processBuilder.start();

        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            line = line.replaceAll("\\s+", " ");
            Logger.info(line);
            winVersion = line;
            winVersion = winVersion.substring(19);
            winvertext.setText("OS: " + winVersion);
        }
    }

    @FXML
    public void homeAct() throws IOException, InterruptedException {
        Logger.info("Windows Home Activation");
        runCommand("Home");
        runCommand("slmgr /skms kms8.msguides.com");
        runCommand("slmgr /ato");
    }

    @FXML
    public void homeNAct() throws IOException, InterruptedException {
        Logger.info("Windows Home N Activation");
        runCommand("Home N");
        runCommand("slmgr /skms kms8.msguides.com");
        runCommand("slmgr /ato");
    }

    @FXML
    public void proAct() throws IOException, InterruptedException {
        Logger.info("Windows Professional Activation");
        runCommand("Professional");
        runCommand("slmgr /skms kms8.msguides.com");
        runCommand("slmgr /ato");
    }

    @FXML
    public void proNAct() throws IOException, InterruptedException {
        Logger.info("Windows Professional N Activation");
        runCommand("Professional N");
        runCommand("slmgr /skms kms8.msguides.com");
        runCommand("slmgr /ato");
    }


    @FXML
    public void eduAct() throws IOException, InterruptedException {
        Logger.info("Windows Education Activation");
        runCommand("Education");
        runCommand("slmgr /skms kms8.msguides.com");
        runCommand("slmgr /ato");
    }

    @FXML
    public void eduNAct() throws IOException, InterruptedException {
        Logger.info("Windows Education N Activation");
        runCommand("Education N");
        runCommand("slmgr /skms kms8.msguides.com");
        runCommand("slmgr /ato");
    }

    @FXML
    public void entAct() throws IOException, InterruptedException {
        Logger.info("Windows Enterprise Activation");
        runCommand("Enterprise");
        runCommand("slmgr /skms kms8.msguides.com");
        runCommand("slmgr /ato");
    }

    @FXML
    public void entNAct() throws IOException, InterruptedException {
        Logger.info("Windows Enterprise N Activation");
        runCommand("Enterprise N");
        runCommand("slmgr /skms kms8.msguides.com");
        runCommand("slmgr /ato");
    }

    @FXML
    public void deactivation() throws IOException, InterruptedException {
        Logger.info("Deactivating...");
        runCommand("slmgr.vbs /upk");
    }
}