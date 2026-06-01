package com.exemple.chat.dto;

public class ChatMessage {

    private String expediteur;
    private String contenu;
    private TypeMessage type;

    public enum TypeMessage {
        CHAT,      // message normal
        ARRIVEE,   // un utilisateur rejoint
        DEPART     // un utilisateur quitte
    }

    // Constructeur vide OBLIGATOIRE pour la désérialisation JSON
    public ChatMessage() {}

    public ChatMessage(String expediteur, String contenu, TypeMessage type) {
        this.expediteur = expediteur;
        this.contenu = contenu;
        this.type = type;
    }

    public String getExpediteur() { return expediteur; }
    public void setExpediteur(String expediteur) { this.expediteur = expediteur; }

    public String getContenu() { return contenu; }
    public void setContenu(String contenu) { this.contenu = contenu; }

    public TypeMessage getType() { return type; }
    public void setType(TypeMessage type) { this.type = type; }
}