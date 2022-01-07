package xyzhotel.model.Responsehandle;


public class Response {


    private boolean action;
    private Object data;
    private Status status;

    public boolean isAction() {
        return action;
    }

    public void setAction(boolean action) {
        this.action = action;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    private enum Status {
        SUCCESS, FAIL, SYSTEM_DOWN
    }

    private Response(Status status, boolean action, Object data) {
        this.status = status;
        this.action = action;
        this.data = data;
    }

    public Response() {

    }

    public static Response success(Object data) {
        return new Response(Status.SUCCESS, true, data);
    }

    public static Response fail(Object data) {
        return new Response(Status.FAIL, false, data);
    }

    public static Response systemDowmn(Object data) {
        return new Response(Status.SYSTEM_DOWN, false, data);
    }

}
