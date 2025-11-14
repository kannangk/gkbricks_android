package com.gk.bricks.interfaces;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\u0010\u0006\u001a\u00060\u0007j\u0002`\bH&J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\u0003H&J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H&\u00a8\u0006\u0011"}, d2 = {"Lcom/gk/bricks/interfaces/OnUpload;", "", "onError", "", "id", "", "ex", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onProgressUpdate", "percentage", "uploadedSize", "", "onUploadFailed", "onUploadSuccess", "url", "", "app_debug"})
public abstract interface OnUpload {
    
    public abstract void onUploadSuccess(@org.jetbrains.annotations.NotNull()
    java.lang.String url);
    
    public abstract void onUploadFailed();
    
    public abstract void onError(int id, @org.jetbrains.annotations.NotNull()
    java.lang.Exception ex);
    
    public abstract void onProgressUpdate(int percentage, long uploadedSize);
}