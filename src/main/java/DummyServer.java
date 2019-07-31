public class DummyServer {
    public static void main(String[] args) throws Exception {
        EchoServerSpike server = new EchoServerSpike();
        int port = Integer.parseInt(args[0]);
        server.start(port);
    }
}
