package com.gk.bricks.adapter;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001%B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\u0002\u0010\bJ\b\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u001c\u0010\u0015\u001a\u00020\u00102\n\u0010\u0016\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u000eH\u0016J\u001c\u0010\u0018\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u000eH\u0016J\u0018\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J(\u0010\u001f\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00122\u0006\u0010#\u001a\u00020\u0012H\u0002J\u0018\u0010$\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020!H\u0002R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006&"}, d2 = {"Lcom/gk/bricks/adapter/ChamberUnloadingLogAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/gk/bricks/adapter/ChamberUnloadingLogAdapter$ViewHolder;", "mContext", "Landroid/content/Context;", "list", "", "Lcom/gk/bricks/model/parse/BricksUnloadingLogs;", "(Landroid/content/Context;Ljava/util/List;)V", "formatter", "Ljava/text/SimpleDateFormat;", "getFormatter", "()Ljava/text/SimpleDateFormat;", "getItemCount", "", "loadProfileImageFromS3", "", "url", "", "ivView", "Landroid/widget/ImageView;", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "showDocumentPopupWithAnimation", "view", "Landroid/view/View;", "showLoadPopup", "data", "Lcom/gk/bricks/model/parse/VendorPaidLog;", "loadName", "date", "showLogPopup", "ViewHolder", "app_debug"})
public final class ChamberUnloadingLogAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.gk.bricks.adapter.ChamberUnloadingLogAdapter.ViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context mContext = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.gk.bricks.model.parse.BricksUnloadingLogs> list = null;
    @org.jetbrains.annotations.NotNull()
    private final java.text.SimpleDateFormat formatter = null;
    
    public ChamberUnloadingLogAdapter(@org.jetbrains.annotations.NotNull()
    android.content.Context mContext, @org.jetbrains.annotations.NotNull()
    java.util.List<com.gk.bricks.model.parse.BricksUnloadingLogs> list) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.text.SimpleDateFormat getFormatter() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public com.gk.bricks.adapter.ChamberUnloadingLogAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.gk.bricks.adapter.ChamberUnloadingLogAdapter.ViewHolder holder, int position) {
    }
    
    private final void showLoadPopup(android.view.View view, com.gk.bricks.model.parse.VendorPaidLog data, java.lang.String loadName, java.lang.String date) {
    }
    
    private final void showLogPopup(android.view.View view, com.gk.bricks.model.parse.VendorPaidLog data) {
    }
    
    private final void loadProfileImageFromS3(java.lang.String url, android.widget.ImageView ivView) {
    }
    
    private final void showDocumentPopupWithAnimation(android.view.View view, java.lang.String url) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0011\u0010\u000b\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\bR\u0011\u0010\r\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\bR\u0011\u0010\u000f\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\b\u00a8\u0006\u0011"}, d2 = {"Lcom/gk/bricks/adapter/ChamberUnloadingLogAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Lcom/gk/bricks/adapter/ChamberUnloadingLogAdapter;Landroid/view/View;)V", "tvDate", "Landroid/widget/TextView;", "getTvDate", "()Landroid/widget/TextView;", "tvLoadCount", "getTvLoadCount", "tvLoadType", "getTvLoadType", "tvName", "getTvName", "tvReceived", "getTvReceived", "app_debug"})
    public final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView tvDate = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView tvName = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView tvLoadCount = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView tvReceived = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView tvLoadType = null;
        
        public ViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View view) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getTvDate() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getTvName() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getTvLoadCount() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getTvReceived() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getTvLoadType() {
            return null;
        }
    }
}