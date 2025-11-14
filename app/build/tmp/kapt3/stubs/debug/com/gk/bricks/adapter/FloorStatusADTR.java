package com.gk.bricks.adapter;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 ,2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003,-.B%\u0012\u0016\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\b\u0010\u0019\u001a\u00020\u0017H\u0016J\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0002H\u0002J\u001a\u0010\u001f\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u00022\b\b\u0001\u0010 \u001a\u00020\u0017H\u0016J\u0018\u0010!\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0017H\u0016J \u0010%\u001a\u00020\u001b2\u0006\u0010&\u001a\u00020\u00172\u0006\u0010\'\u001a\u00020\u00172\u0006\u0010(\u001a\u00020\u0017H\u0002J\u0018\u0010)\u001a\u00020\u001b2\u0006\u0010*\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0002H\u0002J\u0010\u0010+\u001a\u00020\u001b2\u0006\u0010&\u001a\u00020\u0017H\u0002R\u001e\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\u0004j\b\u0012\u0004\u0012\u00020\u000b`\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082D\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R!\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0018\u00a8\u0006/"}, d2 = {"Lcom/gk/bricks/adapter/FloorStatusADTR;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/gk/bricks/adapter/FloorStatusADTR$FloorStatusViewHolder;", "list", "Ljava/util/ArrayList;", "Lcom/gk/bricks/util/Constants$FloorData;", "Lkotlin/collections/ArrayList;", "mContext", "Landroid/content/Context;", "(Ljava/util/ArrayList;Landroid/content/Context;)V", "floorLocalData", "Lcom/gk/bricks/adapter/FloorStatusADTR$Value;", "isAnimating", "", "job", "Lkotlinx/coroutines/Job;", "getJob", "()Lkotlinx/coroutines/Job;", "setJob", "(Lkotlinx/coroutines/Job;)V", "getList", "()Ljava/util/ArrayList;", "previousSelectedFloor", "", "Ljava/lang/Integer;", "getItemCount", "goneAnimation", "", "goneItem", "Landroid/widget/TextView;", "holder", "onBindViewHolder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "selectFloor", "floor", "previousFloor", "current", "startAnimation", "visibleItemView", "unSelectFloor", "Companion", "FloorStatusViewHolder", "Value", "app_debug"})
public final class FloorStatusADTR extends androidx.recyclerview.widget.RecyclerView.Adapter<com.gk.bricks.adapter.FloorStatusADTR.FloorStatusViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private final java.util.ArrayList<com.gk.bricks.util.Constants.FloorData> list = null;
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context mContext = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String TAG = "FloorStatusADTR";
    @org.jetbrains.annotations.NotNull()
    private final java.util.ArrayList<com.gk.bricks.adapter.FloorStatusADTR.Value> floorLocalData = null;
    private final boolean isAnimating = true;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Integer previousSelectedFloor;
    @org.jetbrains.annotations.Nullable()
    private kotlinx.coroutines.Job job;
    @org.jetbrains.annotations.NotNull()
    public static final com.gk.bricks.adapter.FloorStatusADTR.Companion Companion = null;
    
    public FloorStatusADTR(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.gk.bricks.util.Constants.FloorData> list, @org.jetbrains.annotations.NotNull()
    android.content.Context mContext) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.gk.bricks.util.Constants.FloorData> getList() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final kotlinx.coroutines.Job getJob() {
        return null;
    }
    
    public final void setJob(@org.jetbrains.annotations.Nullable()
    kotlinx.coroutines.Job p0) {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public com.gk.bricks.adapter.FloorStatusADTR.FloorStatusViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.gk.bricks.adapter.FloorStatusADTR.FloorStatusViewHolder holder, @android.annotation.SuppressLint(value = {"RecyclerView"})
    int position) {
    }
    
    private final void unSelectFloor(int floor) {
    }
    
    private final void selectFloor(int floor, int previousFloor, int current) {
    }
    
    private final void startAnimation(android.widget.TextView visibleItemView, com.gk.bricks.adapter.FloorStatusADTR.FloorStatusViewHolder holder) {
    }
    
    private final void goneAnimation(android.widget.TextView goneItem, com.gk.bricks.adapter.FloorStatusADTR.FloorStatusViewHolder holder) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/gk/bricks/adapter/FloorStatusADTR$Companion;", "", "()V", "TAG", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/gk/bricks/adapter/FloorStatusADTR$FloorStatusViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/gk/bricks/databinding/FloorItemLlBinding;", "(Lcom/gk/bricks/databinding/FloorItemLlBinding;)V", "getBinding", "()Lcom/gk/bricks/databinding/FloorItemLlBinding;", "app_debug"})
    public static final class FloorStatusViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final com.gk.bricks.databinding.FloorItemLlBinding binding = null;
        
        public FloorStatusViewHolder(@org.jetbrains.annotations.NotNull()
        com.gk.bricks.databinding.FloorItemLlBinding binding) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.gk.bricks.databinding.FloorItemLlBinding getBinding() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\bJ\t\u0010\u0010\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0012\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u0013\u001a\u00020\u0006H\u00c6\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u00c6\u0001J\u0013\u0010\u0015\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0017\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0018\u001a\u00020\u0019H\u00d6\u0001R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\tR\u0011\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\tR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\r\u00a8\u0006\u001a"}, d2 = {"Lcom/gk/bricks/adapter/FloorStatusADTR$Value;", "", "selectedFloor", "", "nextFloor", "isAnimation", "", "isAnimationCompleted", "(IIZZ)V", "()Z", "getNextFloor", "()I", "setNextFloor", "(I)V", "getSelectedFloor", "setSelectedFloor", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "", "app_debug"})
    public static final class Value {
        private int selectedFloor;
        private int nextFloor;
        private final boolean isAnimation = false;
        private final boolean isAnimationCompleted = false;
        
        public Value(int selectedFloor, int nextFloor, boolean isAnimation, boolean isAnimationCompleted) {
            super();
        }
        
        public final int getSelectedFloor() {
            return 0;
        }
        
        public final void setSelectedFloor(int p0) {
        }
        
        public final int getNextFloor() {
            return 0;
        }
        
        public final void setNextFloor(int p0) {
        }
        
        public final boolean isAnimation() {
            return false;
        }
        
        public final boolean isAnimationCompleted() {
            return false;
        }
        
        public Value() {
            super();
        }
        
        public final int component1() {
            return 0;
        }
        
        public final int component2() {
            return 0;
        }
        
        public final boolean component3() {
            return false;
        }
        
        public final boolean component4() {
            return false;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.gk.bricks.adapter.FloorStatusADTR.Value copy(int selectedFloor, int nextFloor, boolean isAnimation, boolean isAnimationCompleted) {
            return null;
        }
        
        @java.lang.Override()
        public boolean equals(@org.jetbrains.annotations.Nullable()
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override()
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public java.lang.String toString() {
            return null;
        }
    }
}