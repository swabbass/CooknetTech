package ward.net.networkcorew.Handlers;

/**
 * Created by ward on 5/8/2015.
 */
public interface BaseResponse<T> {
    void onSuccess(T data);
    void onFail();

}
