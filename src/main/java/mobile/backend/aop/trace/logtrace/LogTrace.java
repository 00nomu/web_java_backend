package mobile.backend.aop.trace.logtrace;


import mobile.backend.aop.trace.TraceStatus;

public interface LogTrace {

    TraceStatus begin(String message);
    void end(TraceStatus status);
    void exception(TraceStatus status, Exception e);
}
