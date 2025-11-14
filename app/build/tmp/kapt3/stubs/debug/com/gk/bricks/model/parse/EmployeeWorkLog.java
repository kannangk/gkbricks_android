package com.gk.bricks.model.parse;

@com.parse.ParseClassName(value = "employeeWorkLog")
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 52\u00020\u0001:\u00015B\u0005\u00a2\u0006\u0002\u0010\u0002R$\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR$\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR$\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR$\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0003\u001a\u00020\u00198F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u0003\u001a\u00020\u00198F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u001e\u0010\u001b\"\u0004\b\u001f\u0010\u001dR$\u0010 \u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b!\u0010\u0007\"\u0004\b\"\u0010\tR\u001a\u0010#\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0007\"\u0004\b%\u0010\tR$\u0010&\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\'\u0010\u0007\"\u0004\b(\u0010\tR$\u0010)\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b*\u0010\u0007\"\u0004\b+\u0010\tR$\u0010,\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b-\u0010\r\"\u0004\b.\u0010\u000fR$\u00100\u001a\u00020/2\u0006\u0010\u0003\u001a\u00020/8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b1\u00102\"\u0004\b3\u00104\u00a8\u00066"}, d2 = {"Lcom/gk/bricks/model/parse/EmployeeWorkLog;", "Lcom/parse/ParseObject;", "()V", "value", "", "afterAdvanceAmount", "getAfterAdvanceAmount", "()I", "setAfterAdvanceAmount", "(I)V", "", "companyName", "getCompanyName", "()Ljava/lang/String;", "setCompanyName", "(Ljava/lang/String;)V", "empId", "getEmpId", "setEmpId", "empName", "getEmpName", "setEmpName", "empSalary", "getEmpSalary", "setEmpSalary", "", "isPaid", "()Z", "setPaid", "(Z)V", "isPayable", "setPayable", "previousAdvanceAmount", "getPreviousAdvanceAmount", "setPreviousAdvanceAmount", "totalAmount", "getTotalAmount", "setTotalAmount", "totalPaidAmount", "getTotalPaidAmount", "setTotalPaidAmount", "totalWorkingSalary", "getTotalWorkingSalary", "setTotalWorkingSalary", "updateFrom", "getUpdateFrom", "setUpdateFrom", "Ljava/util/Date;", "workDate", "getWorkDate", "()Ljava/util/Date;", "setWorkDate", "(Ljava/util/Date;)V", "Companion", "app_debug"})
public final class EmployeeWorkLog extends com.parse.ParseObject {
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_COMPANY_NAME = "companyName";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_EMP_ID = "empId";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_EMP_SALARY = "empSalary";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_WORK_DATE = "workingDate";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_EMP_NAME = "empName";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_IS_PAID = "isPaid";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_IS_PAYABLE = "isPayable";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_TOTAL_PAID_AMOUNT = "totalPaidAmount";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_PREVIOUS_ADVANCE_AMOUNT = "previousAdvanceAmount";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_AFTER_ADVANCE_AMOUNT = "afterAdvanceAmount";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_TOTAL_WORKING_SALARY = "totalWorkingSalary";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_UPDATE_FROM = "updateFrom";
    private int totalAmount = 0;
    @org.jetbrains.annotations.NotNull()
    public static final com.gk.bricks.model.parse.EmployeeWorkLog.Companion Companion = null;
    
    public EmployeeWorkLog() {
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
    public final java.lang.String getEmpId() {
        return null;
    }
    
    public final void setEmpId(@org.jetbrains.annotations.NotNull()
    java.lang.String value) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Date getWorkDate() {
        return null;
    }
    
    public final void setWorkDate(@org.jetbrains.annotations.NotNull()
    java.util.Date value) {
    }
    
    public final int getEmpSalary() {
        return 0;
    }
    
    public final void setEmpSalary(int value) {
    }
    
    public final int getPreviousAdvanceAmount() {
        return 0;
    }
    
    public final void setPreviousAdvanceAmount(int value) {
    }
    
    public final int getAfterAdvanceAmount() {
        return 0;
    }
    
    public final void setAfterAdvanceAmount(int value) {
    }
    
    public final int getTotalWorkingSalary() {
        return 0;
    }
    
    public final void setTotalWorkingSalary(int value) {
    }
    
    public final int getTotalPaidAmount() {
        return 0;
    }
    
    public final void setTotalPaidAmount(int value) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getEmpName() {
        return null;
    }
    
    public final void setEmpName(@org.jetbrains.annotations.NotNull()
    java.lang.String value) {
    }
    
    public final boolean isPaid() {
        return false;
    }
    
    public final void setPaid(boolean value) {
    }
    
    public final boolean isPayable() {
        return false;
    }
    
    public final void setPayable(boolean value) {
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
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0019\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0014\u0010\u000f\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0014\u0010\u0011\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006R\u0014\u0010\u0013\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0006R\u0014\u0010\u0015\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0006R\u0014\u0010\u0017\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0006R\u0014\u0010\u0019\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0006R\u0014\u0010\u001b\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0006\u00a8\u0006\u001d"}, d2 = {"Lcom/gk/bricks/model/parse/EmployeeWorkLog$Companion;", "", "()V", "KEY_AFTER_ADVANCE_AMOUNT", "", "getKEY_AFTER_ADVANCE_AMOUNT", "()Ljava/lang/String;", "KEY_COMPANY_NAME", "getKEY_COMPANY_NAME", "KEY_EMP_ID", "getKEY_EMP_ID", "KEY_EMP_NAME", "getKEY_EMP_NAME", "KEY_EMP_SALARY", "getKEY_EMP_SALARY", "KEY_IS_PAID", "getKEY_IS_PAID", "KEY_IS_PAYABLE", "getKEY_IS_PAYABLE", "KEY_PREVIOUS_ADVANCE_AMOUNT", "getKEY_PREVIOUS_ADVANCE_AMOUNT", "KEY_TOTAL_PAID_AMOUNT", "getKEY_TOTAL_PAID_AMOUNT", "KEY_TOTAL_WORKING_SALARY", "getKEY_TOTAL_WORKING_SALARY", "KEY_UPDATE_FROM", "getKEY_UPDATE_FROM", "KEY_WORK_DATE", "getKEY_WORK_DATE", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getKEY_COMPANY_NAME() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getKEY_EMP_ID() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getKEY_EMP_SALARY() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getKEY_WORK_DATE() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getKEY_EMP_NAME() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getKEY_IS_PAID() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getKEY_IS_PAYABLE() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getKEY_TOTAL_PAID_AMOUNT() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getKEY_PREVIOUS_ADVANCE_AMOUNT() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getKEY_AFTER_ADVANCE_AMOUNT() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getKEY_TOTAL_WORKING_SALARY() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getKEY_UPDATE_FROM() {
            return null;
        }
    }
}