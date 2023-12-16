package com.example.campus_ease.shared.utils.enums;

public enum Branch {

    CS("Computer Science",181l),
    IT("Information Technology",182l),
    EE("Electrical Engineering",183l),
    EC("Electronics and Communication",184l),
    ME("Mechanical Engineering",185l),
    CE("Civil Engineering",186l);

    private String branchName;

    private Long branchId;
    Branch(String branchName,Long branchId){
        this.branchName=branchName;
        this.branchId=branchId;
    }

    public String getBranchName(){
        return branchName;
    }

    public Long getBranchId(){
        return branchId;
    }

}
