package com.elite.x300.base.primarynav;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0006\u0003\u0004\u0005\u0006\u0007\bB\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0006\t\n\u000b\f\r\u000e\u00a8\u0006\u000f"}, d2 = {"Lcom/elite/x300/base/primarynav/NavigationCommand;", "", "()V", "Back", "BackTo", "ToDeepLink", "ToDestinationId", "ToDirections", "ToRoot", "Lcom/elite/x300/base/primarynav/NavigationCommand$Back;", "Lcom/elite/x300/base/primarynav/NavigationCommand$BackTo;", "Lcom/elite/x300/base/primarynav/NavigationCommand$ToDeepLink;", "Lcom/elite/x300/base/primarynav/NavigationCommand$ToDestinationId;", "Lcom/elite/x300/base/primarynav/NavigationCommand$ToDirections;", "Lcom/elite/x300/base/primarynav/NavigationCommand$ToRoot;", "app_debug"})
public abstract class NavigationCommand {
    
    private NavigationCommand() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/elite/x300/base/primarynav/NavigationCommand$Back;", "Lcom/elite/x300/base/primarynav/NavigationCommand;", "()V", "app_debug"})
    public static final class Back extends com.elite.x300.base.primarynav.NavigationCommand {
        @org.jetbrains.annotations.NotNull()
        public static final com.elite.x300.base.primarynav.NavigationCommand.Back INSTANCE = null;
        
        private Back() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\n\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000b\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\r\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u00d6\u0003J\t\u0010\u0010\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0011\u001a\u00020\u0012H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\t\u00a8\u0006\u0013"}, d2 = {"Lcom/elite/x300/base/primarynav/NavigationCommand$BackTo;", "Lcom/elite/x300/base/primarynav/NavigationCommand;", "destinationId", "", "isInclusive", "", "(IZ)V", "getDestinationId", "()I", "()Z", "component1", "component2", "copy", "equals", "other", "", "hashCode", "toString", "", "app_debug"})
    public static final class BackTo extends com.elite.x300.base.primarynav.NavigationCommand {
        private final int destinationId = 0;
        private final boolean isInclusive = false;
        
        public BackTo(int destinationId, boolean isInclusive) {
        }
        
        public final int getDestinationId() {
            return 0;
        }
        
        public final boolean isInclusive() {
            return false;
        }
        
        public final int component1() {
            return 0;
        }
        
        public final boolean component2() {
            return false;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.elite.x300.base.primarynav.NavigationCommand.BackTo copy(int destinationId, boolean isInclusive) {
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
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0011"}, d2 = {"Lcom/elite/x300/base/primarynav/NavigationCommand$ToDeepLink;", "Lcom/elite/x300/base/primarynav/NavigationCommand;", "deepLinkUri", "Landroid/net/Uri;", "(Landroid/net/Uri;)V", "getDeepLinkUri", "()Landroid/net/Uri;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"})
    public static final class ToDeepLink extends com.elite.x300.base.primarynav.NavigationCommand {
        @org.jetbrains.annotations.NotNull()
        private final android.net.Uri deepLinkUri = null;
        
        public ToDeepLink(@org.jetbrains.annotations.NotNull()
        android.net.Uri deepLinkUri) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.net.Uri getDeepLinkUri() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.net.Uri component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.elite.x300.base.primarynav.NavigationCommand.ToDeepLink copy(@org.jetbrains.annotations.NotNull()
        android.net.Uri deepLinkUri) {
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
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u000e\u001a\u00020\u000fH\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0010"}, d2 = {"Lcom/elite/x300/base/primarynav/NavigationCommand$ToDestinationId;", "Lcom/elite/x300/base/primarynav/NavigationCommand;", "destinationId", "", "(I)V", "getDestinationId", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "app_debug"})
    public static final class ToDestinationId extends com.elite.x300.base.primarynav.NavigationCommand {
        private final int destinationId = 0;
        
        public ToDestinationId(int destinationId) {
        }
        
        public final int getDestinationId() {
            return 0;
        }
        
        public final int component1() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.elite.x300.base.primarynav.NavigationCommand.ToDestinationId copy(int destinationId) {
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
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0011"}, d2 = {"Lcom/elite/x300/base/primarynav/NavigationCommand$ToDirections;", "Lcom/elite/x300/base/primarynav/NavigationCommand;", "direction", "Landroidx/navigation/NavDirections;", "(Landroidx/navigation/NavDirections;)V", "getDirection", "()Landroidx/navigation/NavDirections;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"})
    public static final class ToDirections extends com.elite.x300.base.primarynav.NavigationCommand {
        @org.jetbrains.annotations.NotNull()
        private final androidx.navigation.NavDirections direction = null;
        
        public ToDirections(@org.jetbrains.annotations.NotNull()
        androidx.navigation.NavDirections direction) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final androidx.navigation.NavDirections getDirection() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final androidx.navigation.NavDirections component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.elite.x300.base.primarynav.NavigationCommand.ToDirections copy(@org.jetbrains.annotations.NotNull()
        androidx.navigation.NavDirections direction) {
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
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/elite/x300/base/primarynav/NavigationCommand$ToRoot;", "Lcom/elite/x300/base/primarynav/NavigationCommand;", "()V", "app_debug"})
    public static final class ToRoot extends com.elite.x300.base.primarynav.NavigationCommand {
        @org.jetbrains.annotations.NotNull()
        public static final com.elite.x300.base.primarynav.NavigationCommand.ToRoot INSTANCE = null;
        
        private ToRoot() {
        }
    }
}