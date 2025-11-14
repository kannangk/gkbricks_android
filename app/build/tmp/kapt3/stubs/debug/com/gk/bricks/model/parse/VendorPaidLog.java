package com.gk.bricks.model.parse;

@com.parse.ParseClassName(value = "vendorPaidLog")
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 ?2\u00020\u0001:\u0001?B\u0005\u00a2\u0006\u0002\u0010\u0002R$\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR$\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR$\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR$\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0003\u001a\u00020\u00198F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u001f\u0010\u0007\"\u0004\b \u0010\tR$\u0010!\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\"\u0010\r\"\u0004\b#\u0010\u000fR$\u0010$\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b%\u0010\u0007\"\u0004\b&\u0010\tR$\u0010\'\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b(\u0010\u0007\"\u0004\b)\u0010\tR\u001a\u0010*\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0007\"\u0004\b,\u0010\tR$\u0010-\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b.\u0010\u0007\"\u0004\b/\u0010\tR$\u00100\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b1\u0010\r\"\u0004\b2\u0010\u000fR$\u00103\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b4\u0010\r\"\u0004\b5\u0010\u000fR$\u00106\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b7\u0010\r\"\u0004\b8\u0010\u000fR$\u0010:\u001a\u0002092\u0006\u0010\u0003\u001a\u0002098F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>\u00a8\u0006@"}, d2 = {"Lcom/gk/bricks/model/parse/VendorPaidLog;", "Lcom/parse/ParseObject;", "()V", "value", "", "afterRemainingAmount", "getAfterRemainingAmount", "()I", "setAfterRemainingAmount", "(I)V", "", "companyName", "getCompanyName", "()Ljava/lang/String;", "setCompanyName", "(Ljava/lang/String;)V", "documentOne", "getDocumentOne", "setDocumentOne", "documentThree", "getDocumentThree", "setDocumentThree", "documentTwo", "getDocumentTwo", "setDocumentTwo", "", "isPaid", "()Z", "setPaid", "(Z)V", "loadCount", "getLoadCount", "setLoadCount", "loadName", "getLoadName", "setLoadName", "paidAmount", "getPaidAmount", "setPaidAmount", "previousRemainingAmount", "getPreviousRemainingAmount", "setPreviousRemainingAmount", "totalAmount", "getTotalAmount", "setTotalAmount", "totalLoadAmount", "getTotalLoadAmount", "setTotalLoadAmount", "updateFrom", "getUpdateFrom", "setUpdateFrom", "vendorId", "getVendorId", "setVendorId", "vendorType", "getVendorType", "setVendorType", "Ljava/util/Date;", "workDate", "getWorkDate", "()Ljava/util/Date;", "setWorkDate", "(Ljava/util/Date;)V", "Companion", "app_debug"})
public final class VendorPaidLog extends com.parse.ParseObject {
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_COMPANY_NAME = "companyName";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_VENDOR_ID = "vendorId";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_WORK_DATE = "workingDate";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_TOTAL_LOAD_AMOUNT = "totalLoadAmount";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_LOAD_COUNT = "loadCount";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_VENDOR_TYPE = "vendorType";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_LOAD_NAME = "loadName";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_DOCUMENT_ONE = "documentOne";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_DOCUMENT_TWO = "documentTwo";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_DOCUMENT_THREE = "documentThree";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_IS_PAID = "isPaid";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_PAID_AMOUNT = "paidAmount";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_PREVIOUS_REMAINING_AMOUNT = "previousRemainingAmount";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_AFTER_REMAINING_AMOUNT = "afterRemainingAmount";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_UPDATE_FROM = "updateFrom";
    private int totalAmount = 0;
    @org.jetbrains.annotations.NotNull()
    public static final com.gk.bricks.model.parse.VendorPaidLog.Companion Companion = null;
    
    public VendorPaidLog() {
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
    public final java.lang.String getVendorId() {
        return null;
    }
    
    public final void setVendorId(@org.jetbrains.annotations.NotNull()
    java.lang.String value) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Date getWorkDate() {
        return null;
    }
    
    public final void setWorkDate(@org.jetbrains.annotations.NotNull()
    java.util.Date value) {
    }
    
    public final int getTotalLoadAmount() {
        return 0;
    }
    
    public final void setTotalLoadAmount(int value) {
    }
    
    public final int getLoadCount() {
        return 0;
    }
    
    public final void setLoadCount(int value) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getVendorType() {
        return null;
    }
    
    public final void setVendorType(@org.jetbrains.annotations.NotNull()
    java.lang.String value) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getLoadName() {
        return null;
    }
    
    public final void setLoadName(@org.jetbrains.annotations.NotNull()
    java.lang.String value) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDocumentOne() {
        return null;
    }
    
    public final void setDocumentOne(@org.jetbrains.annotations.NotNull()
    java.lang.String value) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDocumentTwo() {
        return null;
    }
    
    public final void setDocumentTwo(@org.jetbrains.annotations.NotNull()
    java.lang.String value) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDocumentThree() {
        return null;
    }
    
    public final void setDocumentThree(@org.jetbrains.annotations.NotNull()
    java.lang.String value) {
    }
    
    public final int getPaidAmount() {
        return 0;
    }
    
    public final void setPaidAmount(int value) {
    }
    
    public final int getPreviousRemainingAmount() {
        return 0;
    }
    
    public final void setPreviousRemainingAmount(int value) {
    }
    
    public final int getAfterRemainingAmount() {
        return 0;
    }
    
    public final void setAfterRemainingAmount(int value) {
    }
    
    public final boolean isPaid() {
        return false;
    }
    
    public final void setPaid(boolean value) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUpdateFrom() {
        return null;
    }
    
    public final void setUpdateFrom(@org.jetbrains.annotations.NotNull()
    java.lang.String value) {
    }
    
    public final int getTotalAmount() {
        return 0;
    }
    
    public final void setTotalAmount(int p0) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u001f\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0014\u0010\u000f\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0014\u0010\u0011\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006R\u0014\u0010\u0013\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0006R\u0014\u0010\u0015\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0006R\u0014\u0010\u0017\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0006R\u0014\u0010\u0019\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0006R\u0014\u0010\u001b\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0006R\u0014\u0010\u001d\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0006R\u0014\u0010\u001f\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u0006R\u0014\u0010!\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0006\u00a8\u0006#"}, d2 = {"Lcom/gk/bricks/model/parse/VendorPaidLog$Companion;", "", "()V", "KEY_AFTER_REMAINING_AMOUNT", "", "getKEY_AFTER_REMAINING_AMOUNT", "()Ljava/lang/String;", "KEY_COMPANY_NAME", "getKEY_COMPANY_NAME", "KEY_DOCUMENT_ONE", "getKEY_DOCUMENT_ONE", "KEY_DOCUMENT_THREE", "getKEY_DOCUMENT_THREE", "KEY_DOCUMENT_TWO", "getKEY_DOCUMENT_TWO", "KEY_IS_PAID", "getKEY_IS_PAID", "KEY_LOAD_COUNT", "getKEY_LOAD_COUNT", "KEY_LOAD_NAME", "getKEY_LOAD_NAME", "KEY_PAID_AMOUNT", "getKEY_PAID_AMOUNT", "KEY_PREVIOUS_REMAINING_AMOUNT", "getKEY_PREVIOUS_REMAINING_AMOUNT", "KEY_TOTAL_LOAD_AMOUNT", "getKEY_TOTAL_LOAD_AMOUNT", "KEY_UPDATE_FROM", "getKEY_UPDATE_FROM", "KEY_VENDOR_ID", "getKEY_VENDOR_ID", "KEY_VENDOR_TYPE", "getKEY_VENDOR_TYPE", "KEY_WORK_DATE", "getKEY_WORK_DATE", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getKEY_COMPANY_NAME() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getKEY_VENDOR_ID() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getKEY_WORK_DATE() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getKEY_TOTAL_LOAD_AMOUNT() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getKEY_LOAD_COUNT() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getKEY_VENDOR_TYPE() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getKEY_LOAD_NAME() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getKEY_DOCUMENT_ONE() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getKEY_DOCUMENT_TWO() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getKEY_DOCUMENT_THREE() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getKEY_IS_PAID() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getKEY_PAID_AMOUNT() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getKEY_PREVIOUS_REMAINING_AMOUNT() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getKEY_AFTER_REMAINING_AMOUNT() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getKEY_UPDATE_FROM() {
            return null;
        }
    }
}