package com.gk.bricks.model.parse;

@com.parse.ParseClassName(value = "employee")
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\r\b\u0007\u0018\u0000 +2\u00020\u0001:\u0001+B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010)\u001a\u00020\u00002\u0006\u0010*\u001a\u00020\u0004R$\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR$\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR$\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR$\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR$\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u001d\u0010\u0007\"\u0004\b\u001e\u0010\tR$\u0010 \u001a\u00020\u001f2\u0006\u0010\u0003\u001a\u00020\u001f8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020\u001fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010!\"\u0004\b%\u0010#R$\u0010&\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\'\u0010\u0007\"\u0004\b(\u0010\t\u00a8\u0006,"}, d2 = {"Lcom/gk/bricks/model/parse/Employee;", "Lcom/parse/ParseObject;", "()V", "value", "", "companyName", "getCompanyName", "()Ljava/lang/String;", "setCompanyName", "(Ljava/lang/String;)V", "", "empAdvance", "getEmpAdvance", "()I", "setEmpAdvance", "(I)V", "empId", "getEmpId", "setEmpId", "empName", "getEmpName", "setEmpName", "empPhoto", "getEmpPhoto", "setEmpPhoto", "empSalary", "getEmpSalary", "setEmpSalary", "empSex", "getEmpSex", "setEmpSex", "", "isBlocked", "()Z", "setBlocked", "(Z)V", "isUpdated", "setUpdated", "updateFrom", "getUpdateFrom", "setUpdateFrom", "parseEmployeeFromJson", "jsonString", "Companion", "app_debug"})
public final class Employee extends com.parse.ParseObject {
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_COMPANY_NAME = "companyName";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_EMP_ID = "empId";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_EMP_NAME = "empName";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_EMP_SEX = "empSex";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_EMP_SALARY = "empSalary";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_EMP_ADVANCE = "empAdvance";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_EMP_PHOTO = "empPhoto";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_IS_BLOCKED = "isBlocked";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_UPDATE_FROM = "updateFrom";
    private boolean isUpdated = true;
    @org.jetbrains.annotations.NotNull()
    public static final com.gk.bricks.model.parse.Employee.Companion Companion = null;
    
    public Employee() {
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
    public final java.lang.String getEmpName() {
        return null;
    }
    
    public final void setEmpName(@org.jetbrains.annotations.NotNull()
    java.lang.String value) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getEmpSex() {
        return null;
    }
    
    public final void setEmpSex(@org.jetbrains.annotations.NotNull()
    java.lang.String value) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getEmpPhoto() {
        return null;
    }
    
    public final void setEmpPhoto(@org.jetbrains.annotations.NotNull()
    java.lang.String value) {
    }
    
    public final int getEmpSalary() {
        return 0;
    }
    
    public final void setEmpSalary(int value) {
    }
    
    public final int getEmpAdvance() {
        return 0;
    }
    
    public final void setEmpAdvance(int value) {
    }
    
    public final boolean isBlocked() {
        return false;
    }
    
    public final void setBlocked(boolean value) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUpdateFrom() {
        return null;
    }
    
    public final void setUpdateFrom(@org.jetbrains.annotations.NotNull()
    java.lang.String value) {
    }
    
    public final boolean isUpdated() {
        return false;
    }
    
    public final void setUpdated(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.gk.bricks.model.parse.Employee parseEmployeeFromJson(@org.jetbrains.annotations.NotNull()
    java.lang.String jsonString) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0013\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0014\u0010\u000f\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0014\u0010\u0011\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006R\u0014\u0010\u0013\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0006R\u0014\u0010\u0015\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0006\u00a8\u0006\u0017"}, d2 = {"Lcom/gk/bricks/model/parse/Employee$Companion;", "", "()V", "KEY_COMPANY_NAME", "", "getKEY_COMPANY_NAME", "()Ljava/lang/String;", "KEY_EMP_ADVANCE", "getKEY_EMP_ADVANCE", "KEY_EMP_ID", "getKEY_EMP_ID", "KEY_EMP_NAME", "getKEY_EMP_NAME", "KEY_EMP_PHOTO", "getKEY_EMP_PHOTO", "KEY_EMP_SALARY", "getKEY_EMP_SALARY", "KEY_EMP_SEX", "getKEY_EMP_SEX", "KEY_IS_BLOCKED", "getKEY_IS_BLOCKED", "KEY_UPDATE_FROM", "getKEY_UPDATE_FROM", "app_debug"})
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
        public final java.lang.String getKEY_EMP_NAME() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getKEY_EMP_SEX() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getKEY_EMP_SALARY() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getKEY_EMP_ADVANCE() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getKEY_EMP_PHOTO() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getKEY_IS_BLOCKED() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getKEY_UPDATE_FROM() {
            return null;
        }
    }
}