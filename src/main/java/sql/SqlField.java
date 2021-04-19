/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sql;

/**
 *
 * @author kcook
 */
public class SqlField {
    private String  fldName;
    private String  fldType;
    private String  fldNull;
    private String  fldKey;
    private String  fldDflt;
    private String  fldExtra;

    public SqlField() {
    }

    public SqlField(String fldName, String fldType, String fldNull, String ky, String fldDflt, String fldExtra) {
        this.fldName = fldName;
        this.fldType = fldType;
        this.fldNull = fldNull;
        this.fldKey = ky;
        this.fldDflt = fldDflt;
        this.fldExtra = fldExtra;
    }

    public String getFldName() {
        return fldName;
    }

    public void setFldName(String fldName) {
        this.fldName = fldName;
    }

    public String getFldType() {
        return fldType;
    }

    public void setFldType(String fldType) {
        this.fldType = fldType;
    }

    public String getFldNull() {
        return fldNull;
    }

    public void setFldNull(String fldNull) {
        this.fldNull = fldNull;
    }

    public String getFldKey() {
        return fldKey;
    }

    public void setFldKey(String fldKey) {
        this.fldKey = fldKey;
    }

    public String getFldDflt() {
        return fldDflt;
    }

    public void setFldDflt(String fldDflt) {
        this.fldDflt = fldDflt;
    }

    public String getFldExtra() {
        return fldExtra;
    }

    public void setFldExtra(String fldExtra) {
        this.fldExtra = fldExtra;
    }
    
    
}
