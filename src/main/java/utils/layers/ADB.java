package utils.layers;

public class ADB {

    private String deviceID;

    public ADB(String deviceID) {
        this.deviceID = deviceID;
    }

    public static String command (String command){
        if(command.startsWith("adb"))
            command = command.replace("adb", ServerManager.getAndroidHome()+"/platform-tools/adb");//
        else throw new RuntimeException("This method is designed to run ADB commands only");
        String output = ServerManager.runCommand(command);
        if (output == null) return "";
        else return output.trim();
    }

    public boolean isKeyboardActivated(){
        String response = command("adb -s " + deviceID + " shell dumpsys input_method | grep mInputShown");
        return response.contains("mInputShown=true");
    }
}
