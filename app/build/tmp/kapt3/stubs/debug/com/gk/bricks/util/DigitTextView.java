package com.gk.bricks.util;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0007J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u000e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0013J\u001e\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0013R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2 = {"Lcom/gk/bricks/util/DigitTextView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "currentTextView", "Landroid/widget/TextView;", "getCurrentTextView", "()Landroid/widget/TextView;", "setCurrentTextView", "(Landroid/widget/TextView;)V", "nextTextView", "init", "", "setOldValue", "oldVal", "", "setValue", "desiredValue", "updateCurrentFloor", "isDownCall", "", "progress", "", "totalFloors", "Companion", "app_debug"})
public final class DigitTextView extends android.widget.FrameLayout {
    @org.jetbrains.annotations.Nullable()
    private android.widget.TextView currentTextView;
    @org.jetbrains.annotations.Nullable()
    private android.widget.TextView nextTextView;
    private static final int ANIMATION_DURATION = 100;
    private static final int SPEED_ANIMATION_DURATION = 0;
    @org.jetbrains.annotations.NotNull()
    public static final com.gk.bricks.util.DigitTextView.Companion Companion = null;
    
    @org.jetbrains.annotations.Nullable()
    public final android.widget.TextView getCurrentTextView() {
        return null;
    }
    
    public final void setCurrentTextView(@org.jetbrains.annotations.Nullable()
    android.widget.TextView p0) {
    }
    
    public DigitTextView(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    android.util.AttributeSet attrs) {
        super(null);
    }
    
    public DigitTextView(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super(null);
    }
    
    private final void init(android.content.Context context) {
    }
    
    public final void updateCurrentFloor(boolean isDownCall, float progress, int totalFloors) {
    }
    
    public final void setOldValue(int oldVal) {
    }
    
    public final void setValue(int desiredValue) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/gk/bricks/util/DigitTextView$Companion;", "", "()V", "ANIMATION_DURATION", "", "SPEED_ANIMATION_DURATION", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}