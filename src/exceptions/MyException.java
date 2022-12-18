package exceptions;

public class MyException {
    public static class EmptyException extends RuntimeException {
        public EmptyException(String name) {
            super(name);
        }
    }
    public static class ScenarioException extends Exception {
        public ScenarioException() {
            super();
        }
    }
}
