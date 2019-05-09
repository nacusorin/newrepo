package ro.sci.g14.jdbc;

public class AccomodationFairRelation {

    private int id;
    private int idAccomodation;
    private int idRoomFair;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdAccomodation() {
        return idAccomodation;
    }

    public void setIdAccomodation(int idAccomodation) {
        this.idAccomodation = idAccomodation;
    }

    public int getIdRoomFair() {
        return idRoomFair;
    }

    public void setIdRoomFair(int idRoomFair) {
        this.idRoomFair = idRoomFair;
    }

    @Override
    public String toString() {
        return "AccomodationFairRelation{" +
                "id=" + id +
                ", idAccomodation=" + idAccomodation +
                ", idRoomFair=" + idRoomFair +
                '}';
    }
}
