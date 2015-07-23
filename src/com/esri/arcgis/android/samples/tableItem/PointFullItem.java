package com.esri.arcgis.android.samples.tableItem;
import java.io.Serializable;

import com.j256.ormlite.field.DatabaseField; 
public class PointFullItem implements Serializable,IExportFunction {	
	public PointFullItem(int id, String name, String PersonID,String housID, String groundID,
			String groundSize, String other, double lat, double lng,
			String imgPath) {
		super();
		this.ID = id;
		this.name = name;
		this.PersonID=PersonID;
		this.housID = housID;
		this.groundID = groundID;
		this.groundSize = groundSize;
		this.other = other;
		this.lat = lat;
		this.lng = lng;
		this.imgPath = imgPath;
	}	
	public PointFullItem() {
		super();
	}
	private static final long serialVersionUID = -5683263669918171030L;  
	/*  <item >Ҫ��ID</item>
       <item >����</item>
       <item >����</item>
       <item >�ؿ��</item>
       <item >���</item>
       <item >��ע</item>
       <item >����</item>
       <item >γ��</item>��
       <item >������Ƭ���</item>
       <item >ɾ��</item>
    */
   @DatabaseField(generatedId=true)  
   private int ID;  
   @DatabaseField  
   private String name;
   @DatabaseField  
   private String PersonID;
   @DatabaseField  
   private String housID;
   @DatabaseField  
   private String groundID;
   @DatabaseField  
   private String groundSize;
   @DatabaseField  
   private String other;
   @DatabaseField  
   private double lat;
   @DatabaseField  
   private double lng;
   private String code;
   @DatabaseField
   private String imgPath;   
   public String getPersonID() {
	return PersonID;
}
public void setPersonID(String personID) {
	PersonID = personID;
}

   public int getId() {
	return ID;
	}
	public void setId(int id) {
		this.ID = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHousID() {
		return housID;
	}
	public void setHousID(String housID) {
		this.housID = housID;
	}
	public String getGroundID() {
		return groundID;
	}
	public void setGroundID(String groundID) {
		this.groundID = groundID;
	}
	public String getGroundSize() {
		return groundSize;
	}
	public void setGroundSize(String groundSize) {
		this.groundSize = groundSize;
	}
	public String getOther() {
		return other;
	}
	public void setOther(String other) {
		this.other = other;
	}
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public double getLng() {
		return lng;
	}
	public void setLng(double lng) {
		this.lng = lng;
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	@Override
	public String getCvsTitle() {
		// TODO Auto-generated method stub
		//return null;
		return "Ҫ�ر��,����,���֤��,����,�ؿ��,��ͬ���,��ע,����,γ��,������Ƭ���";
	}
	@Override
	public String getCvsData() {
		// TODO Auto-generated method stub
		//return null;
		return String.format("%d,%s,%s,%s,%s,%s,%s,%f,%f,%s",ID,name,PersonID,housID,groundID,groundSize,other,lng,lat,imgPath);
	} 
     
}  

