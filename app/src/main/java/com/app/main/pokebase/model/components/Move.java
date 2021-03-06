package com.app.main.pokebase.model.components;

/**
 * @author Tyler Wong
 */
public class Move {
   private int mMoveId;
   private String mName;
   private int mTypeId;
   private int mPower;
   private int mPp;
   private int mAccuracy;
   private String mClassName;
   private String mDescription;
   private String mTypeName;

   public Move(int moveId, String name, int typeId, int power, int pp, int accuracy, String className) {
      this.mMoveId = moveId;
      this.mName = name;
      this.mTypeId = typeId;
      this.mPower = power;
      this.mPp = pp;
      this.mAccuracy = accuracy;
      this.mClassName = className;
   }

   public int getMoveId() {
      return mMoveId;
   }

   public String getName() {
      return mName;
   }

   public int getTypeId() {
      return mTypeId;
   }

   public int getPower() {
      return mPower;
   }

   public int getPp() {
      return mPp;
   }

   public int getAccuracy() {
      return mAccuracy;
   }

   public String getClassName() {
      return mClassName;
   }

   public String getDescription() {
      return mDescription;
   }

   public String getTypeName() {
      return mTypeName;
   }

   public void setDescription(String description) {
      this.mDescription = description;
   }

   public void setTypeName(String typeName) {
      this.mTypeName = typeName;
   }
}
