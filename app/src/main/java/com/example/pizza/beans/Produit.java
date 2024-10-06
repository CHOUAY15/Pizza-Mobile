package com.example.pizza.beans;

import java.io.Serializable;

public class Produit implements Serializable {

    private static  int compteur;



    private int id,nbrIngredient,photo;
    private String nom,description,preparation,detaisIngred,duree;


    public Produit(String nom, int nbrIngredients, int photo,String duree,String detaisIngred,String description,String preparation) {
        this.id = ++compteur;
        this.nom = nom;
        this.nbrIngredient = nbrIngredients;
        this.photo = photo;
        this.duree=duree;
        this.detaisIngred=detaisIngred;
        this.description=description;
        this.preparation=preparation;
    }

    @Override
    public String toString() {
        return "Produit{" +
                "id=" + id +
                ", nbrIngredient=" + nbrIngredient +
                ", photo=" + photo +
                ", nom='" + nom + '\'' +
                ", description='" + description + '\'' +
                ", preparation='" + preparation + '\'' +
                ", detaisIngred='" + detaisIngred + '\'' +
                ", duree=" + duree +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNbrIngredient(int nbrIngredient) {
        this.nbrIngredient = nbrIngredient;
    }



    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPreparation(String preparation) {
        this.preparation = preparation;
    }

    public void setDetaisIngred(String detaisIngred) {
        this.detaisIngred = detaisIngred;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public int getId() {
        return id;
    }

    public int getNbrIngredient() {
        return nbrIngredient;
    }

    public int getPhoto() {
        return photo;
    }



    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return description;
    }

    public String getPreparation() {
        return preparation;
    }

    public String getDetaisIngred() {
        return detaisIngred;
    }

    public String getDuree() {
        return duree;
    }
}
