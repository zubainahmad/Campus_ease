package com.example.campus_ease.shared.utils.enums;

public enum Branch {

    CS("Computer Science",181l),
    IT("Information Technology",182l),
    EN("Electrical Engineering",183l),
    ECE("Electronics and Communication",184l),
    ME("Mechanical Engineering",185l),
    CE("Civil Engineering",186l),
    CSE ("Computer Science Engineering",187l),
    CSE_AIML("Computer Science Engineering - AIML",188l),

    CSE_DS("Computer Science Engineering - Data Science",189l);





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
