package com.gk.bricks.model.parse;

@com.parse.ParseClassName(value = "bricksChamberLoading")
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0016\b\u0007\u0018\u0000 -2\u00020\u0001:\u0001-B\u0005\u00a2\u0006\u0002\u0010\u0002R$\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR$\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00138F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u00188F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u00188F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001dR$\u0010!\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u00188F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\"\u0010\u001b\"\u0004\b#\u0010\u001dR$\u0010$\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u00188F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b%\u0010\u001b\"\u0004\b&\u0010\u001dR$\u0010\'\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u00188F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b(\u0010\u001b\"\u0004\b)\u0010\u001dR$\u0010*\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b+\u0010\r\"\u0004\b,\u0010\u000f\u00a8\u0006."}, d2 = {"Lcom/gk/bricks/model/parse/BricksChamberLoading;", "Lcom/parse/ParseObject;", "()V", "value", "Ljava/util/Date;", "chamberCreateDate", "getChamberCreateDate", "()Ljava/util/Date;", "setChamberCreateDate", "(Ljava/util/Date;)V", "", "chamberId", "getChamberId", "()Ljava/lang/String;", "setChamberId", "(Ljava/lang/String;)V", "companyName", "getCompanyName", "setCompanyName", "", "isCompleted", "()Z", "setCompleted", "(Z)V", "", "totalBricks", "getTotalBricks", "()I", "setTotalBricks", "(I)V", "totalPaidAmount", "getTotalPaidAmount", "setTotalPaidAmount", "totalReceivedAmount", "getTotalReceivedAmount", "setTotalReceivedAmount", "totalSurukki", "getTotalSurukki", "setTotalSurukki", "totalTakenBricks", "getTotalTakenBricks", "setTotalTakenBricks", "updateFrom", "getUpdateFrom", "setUpdateFrom", "Companion", "app_debug"})
public final class BricksChamberLoading extends com.parse.ParseObject {
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_CHAMBER_ID = "chamberId";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_COMPANY_NAME = "companyName";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_CHAMBER_CREATE_DATE = "chamberCreateDate";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_TOTAL_BRICKS = "totalBricks";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_TOTAL_SURUKKI = "totalSurukki";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_TOTAL_PAID_AMOUNT = "totalPaidAmount";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_TOTAL_RECEIVED_AMOUNT = "totalReceivedAmount";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_TOTAL_TAKEN_BRICKS = "totalTakenBricks";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_IS_COMPLETED = "isCompleted";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_UPDATE_FROM = "updateFrom";
    @org.jetbrains.annotations.NotNull()
    public static final com.gk.bricks.model.parse.BricksChamberLoading.Companion Companion = null;
    
    public BricksChamberLoading() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCompanyName() {
        return null;
    }
    
    public final void setCompanyName(@org.jetbrains.annotations.NotNull()
    java.lang.String value) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getChamberId() {
        return null;
    }
    
    public final void setChamberId(@org.jetbrains.annotations.NotNull()
    java.lang.String value) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Date getChamberCreateDate() {
        return null;
    }
    
    public final void setChamberCreateDate(@org.jetbrains.annotations.NotNull()
    java.util.Date value) {
    }
    
    public final int getTotalBricks() {
        return 0;
    }
    
    public final void setTotalBricks(int value) {
    }
    
    public final int getTotalSurukki() {
        return 0;
    }
    
    public final void setTotalSurukki(int value) {
    }
    
    public final int getTotalPaidAmount() {
        return 0;
    }
    
    public final void setTotalPaidAmount(int value) {
    }
    
    public final int getTotalReceivedAmount() {
        return 0;
    }
    
    public final void setTotalReceivedAmount(int value) {
    }
    
    public final int getTotalTakenBricks() {
        return 0;
    }
    
    public final void setTotalTakenBricks(int value) {
    }
    
    public final boolean isCompleted() {
        return false;
    }
    
    public final void setCompleted(boolean value) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUpdateFrom() {
        return null;
    }
    
    public final void setUpdateFrom(@org.jetbrains.annotations.NotNull()
    java.lang.String value) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0015\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0014\u0010\u000f\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0014\u0010\u0011\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006R\u0014\u0010\u0013\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0006R\u0014\u0010\u0015\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0006R\u0014\u0010\u0017\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0006\u00a8\u0006\u0019"}, d2 = {"Lcom/gk/bricks/model/parse/BricksChamberLoading$Companion;", "", "()V", "KEY_CHAMBER_CREATE_DATE", "", "getKEY_CHAMBER_CREATE_DATE", "()Ljava/lang/String;", "KEY_CHAMBER_ID", "getKEY_CHAMBER_ID", "KEY_COMPANY_NAME", "getKEY_COMPANY_NAME", "KEY_IS_COMPLETED", "getKEY_IS_COMPLETED", "KEY_TOTAL_BRICKS", "getKEY_TOTAL_BRICKS", "KEY_TOTAL_PAID_AMOUNT", "getKEY_TOTAL_PAID_AMOUNT", "KEY_TOTAL_RECEIVED_AMOUNT", "getKEY_TOTAL_RECEIVED_AMOUNT", "KEY_TOTAL_SURUKKI", "getKEY_TOTAL_SURUKKI", "KEY_TOTAL_TAKEN_BRICKS", "getKEY_TOTAL_TAKEN_BRICKS", "KEY_UPDATE_FROM", "getKEY_UPDATE_FROM", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getKEY_CHAMBER_ID() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getKEY_COMPANY_NAME() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getKEY_CHAMBER_CREATE_DATE() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getKEY_TOTAL_BRICKS() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getKEY_TOTAL_SURUKKI() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getKEY_TOTAL_PAID_AMOUNT() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getKEY_TOTAL_RECEIVED_AMOUNT() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getKEY_TOTAL_TAKEN_BRICKS() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getKEY_IS_COMPLETED() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getKEY_UPDATE_FROM() {
            return null;
        }
    }
}