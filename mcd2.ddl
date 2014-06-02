-- *********************************************
-- * SQL MySQL generation                      
-- *--------------------------------------------
-- * DB-MAIN version: 9.1.6              
-- * Generator date: Feb 25 2013              
-- * Generation date: Sun Jun 01 17:02:31 2014 
-- * LUN file: C:\Users\bourhou.tarik\Desktop\projet pour juin\mld2.lun 
-- * Schema: mcd2/1-1 
-- ********************************************* 


-- Database Section
-- ________________ 

-- create database mcd2;
-- use mcd2;


-- Tables Section
-- _____________ 

create table Adresse (
     rue char(1) not null,
     num char(1) not null,
     ville char(1) not null,
     zip char(1) not null);

create table CategorieJeux (
     IdCategorie char(1) not null,
     nom char(1) not null,
     genre char(1) not null,
     pegi char(1) not null,
     constraint IDCategorieJeux primary key (IdCategorie));

create table Client (
     IdClient char(1) not null,
     nom char(1) not null,
     prenom char(1) not null,
     telephone char(1) not null,
     constraint IDClient primary key (IdClient));

create table Commande (
     numdecommande char(1) not null,
     nomduproduit char(1) not null,
     constructeur char(1) not null,
     nbredecommande char(1) not null,
     datedecommande char(1) not null);

create table Console (
     IdConsole char(1) not null,
     nom char(1) not null,
     prix char(1) not null,
     caracteristique char(1) not null,
     constraint IDConsole primary key (IdConsole));

create table Facture (
     IdFacture char(1) not null,
     nomProduit char(1) not null,
     prixHtva char(1) not null,
     prixTVA char(1) not null,
     nomClient char(1) not null,
     adresse char(1) not null,
     constraint IDFacture primary key (IdFacture));

create table Fournisseur (
     idFournis char(1) not null,
     NomEntreprise char(1) not null,
     constraint IDFournisseur primary key (idFournis));

create table Jeux (
     IdJeux char(1) not null,
     nom char(1) not null,
     numserie char(1) not null,
     prix char(1) not null,
     description char(1) not null,
     constraint IDJeux primary key (IdJeux));

create table Vendeur (
     idVendeur char(1) not null,
     Nom char(1) not null,
     prenom char(1) not null,
     telephone char(1) not null,
     constraint IDVendeur primary key (idVendeur));


-- Constraints Section
-- ___________________ 


-- Index Section
-- _____________ 

