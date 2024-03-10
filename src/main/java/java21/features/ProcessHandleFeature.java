package java21.features;

public class ProcessHandleFeature {
    public static void main(String[] args) {
        ProcessHandle currentProcess = ProcessHandle.current();
        System.out.println("Process ID: " + currentProcess.pid());
        System.out.println("Is alive? " + currentProcess.isAlive());
    }
}