package module;

public class user {
    private String name;
    private String idUser;
    private String type;
    private String idReceive;

    public user(String name,String idUser,String type, String idReceive ){
        this.name = name;
        this.idUser = idUser;
        this.type = type;
    }

    public String getIdUser(){return idUser;}
    public String getName(){return name;}
    public String getType(){return type;}
    public String getIdReceive(){return idReceive;}

    public void setIdReceive(String idReceive){this.idReceive = idReceive;}
    public void setType(String type){this.type = type;}
}
