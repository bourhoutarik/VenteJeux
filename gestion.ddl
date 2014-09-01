-- *********************************************
-- * SQL MySQL generation                      
-- *--------------------------------------------
-- * DB-MAIN version: 9.1.6              
-- * Generator date: Feb 25 2013              
-- * Generation date: Wed Jun 11 16:38:47 2014 
-- * LUN file: C:\Users\bourhou.tarik\Desktop\projet pour juin\gestionJeux.lun 
-- * Schema: mldCorection/1-1-1-1 
-- ********************************************* 


-- Database Section
-- ________________ 

create database mldCorection;
use mldCorection;


-- Tables Section
-- _____________ 

create table Adresse (
     IdAdresse char(1) not null,
     rue varchar(100) not null,
     num int not null,
     ville varchar(100) not null,
     zip bigint not null,
     constraint ID_Adresse_ID primary key (IdAdresse));

create table Categorie (
     IdCategorie char(1) not null,
     nom varchar(100) not null,
     genre varchar(100) not null,
     pegi int not null,
     constraint ID_Categorie_ID primary key (IdCategorie));

create table Client (
     IdClient char(1) not null,
     nom varchar(100) not null,
     prenom varchar(100) not null,
     telephone bigint not null,
     IdAdresse char(1) not null,
     constraint ID_Client_ID primary key (IdClient));

create table Commande (
     IdCommande char(1) not null,
     numdecommande int not null,
     nomduproduit varchar(100) not null,
     constructeur varchar(100) not null,
     nbredecommande char(1) not null,
     datedecommande char(1) not null,
     idVendeur char(1) not null,
     idFournis char(1) not null,
     constraint ID_Commande_ID primary key (IdCommande));

create table Facture (
     IdFacture char(1) not null,
     nrFacture bigint not null,
     dateFacturation date not null,
     modePaiement varchar(100) not null,
     typeAchat varchar(100) not null,
     quantite bigint not null,
     nomClient varchar(100) not null,
     IdClient char(1) not null,
     IdAdresse char(1),
     constraint ID_Facture_ID primary key (IdFacture));

create table Fournisseur (
     idFournis char(1) not null,
     NomEntreprise varchar(100) not null,
     NumTVA varchar(100) not null,
     IdAdresse char(1) not null,
     constraint ID_Fournisseur_ID primary key (idFournis));

create table Produit (
     IdProduit char(1) not null,
     reference bigint not null,
     prixHTVA bigint not null,
     tauxTVA bigint not null,
     numSerie bigint not null,
     description varchar(100) not null,
     constraint ID_Produit_ID primary key (IdProduit));

create table Ajout_d_un_produit (
     IdProduit char(1) not null,
     IdTypeproduit char(1) not null,
     constraint ID_Ajout_d_un_produit_ID primary key (IdProduit, IdTypeproduit));

create table ajout_du_produit_en_facture (
     IdFacture char(1) not null,
     IdProduit char(1) not null,
     constraint ID_ajout_du_produit_en_facture_ID primary key (IdFacture, IdProduit));

create table quantite1 (
     IdCommande char(1) not null,
     IdProduit char(1) not null,
     constraint ID_quantite1_ID primary key (IdProduit, IdCommande));

create table type_de_categorie (
     IdCategorie char(1) not null,
     IdProduit char(1) not null,
     constraint ID_type_de_categorie_ID primary key (IdProduit, IdCategorie));

create table TypeProduit (
     IdTypeproduit char(1) not null,
     type varchar(100) not null,
     constraint ID_TypeProduit_ID primary key (IdTypeproduit));

create table Vendeur (
     idVendeur char(1) not null,
     Nom varchar(100) not null,
     prenom varchar(100) not null,
     telephone varchar(100) not null,
     constraint ID_Vendeur_ID primary key (idVendeur));


-- Constraints Section
-- ___________________ 

-- Not implemented
-- alter table Adresse add constraint ID_Adresse_CHK
--     check(exists(select * from Client
--                  where Client.IdAdresse = IdAdresse)); 

-- Not implemented
-- alter table Adresse add constraint ID_Adresse_CHK
--     check(exists(select * from Fournisseur
--                  where Fournisseur.IdAdresse = IdAdresse)); 

alter table Client add constraint FKadresse_du_client_FK
     foreign key (IdAdresse)
     references Adresse (IdAdresse);

-- Not implemented
-- alter table Commande add constraint ID_Commande_CHK
--     check(exists(select * from quantite1
--                  where quantite1.IdCommande = IdCommande)); 

alter table Commande add constraint FKreception_de_la_commande_FK
     foreign key (idVendeur)
     references Vendeur (idVendeur);

alter table Commande add constraint FKEnvoit_des_commandes_FK
     foreign key (idFournis)
     references Fournisseur (idFournis);

-- Not implemented
-- alter table Facture add constraint ID_Facture_CHK
--     check(exists(select * from ajout_du_produit_en_facture
--                  where ajout_du_produit_en_facture.IdFacture = IdFacture)); 

alter table Facture add constraint FKajout_du_client__FK
     foreign key (IdClient)
     references Client (IdClient);

alter table Facture add constraint FKajout_de_l_adresse_du_client_FK
     foreign key (IdAdresse)
     references Adresse (IdAdresse);

alter table Fournisseur add constraint FKadresse_du_fournisseur_FK
     foreign key (IdAdresse)
     references Adresse (IdAdresse);

-- Not implemented
-- alter table Produit add constraint ID_Produit_CHK
--     check(exists(select * from Ajout_d_un_produit
--                  where Ajout_d_un_produit.IdProduit = IdProduit)); 

-- Not implemented
-- alter table Produit add constraint ID_Produit_CHK
--     check(exists(select * from type_de_categorie
--                  where type_de_categorie.IdProduit = IdProduit)); 

alter table Ajout_d_un_produit add constraint FKAjo_Typ_FK
     foreign key (IdTypeproduit)
     references TypeProduit (IdTypeproduit);

alter table Ajout_d_un_produit add constraint FKAjo_Pro_1
     foreign key (IdProduit)
     references Produit (IdProduit);

alter table ajout_du_produit_en_facture add constraint FKajo_Pro_FK
     foreign key (IdProduit)
     references Produit (IdProduit);

alter table ajout_du_produit_en_facture add constraint FKajo_Fac
     foreign key (IdFacture)
     references Facture (IdFacture);

alter table quantite1 add constraint FKqua_Pro
     foreign key (IdProduit)
     references Produit (IdProduit);

alter table quantite1 add constraint FKqua_Com_FK
     foreign key (IdCommande)
     references Commande (IdCommande);

alter table type_de_categorie add constraint FKtyp_Pro
     foreign key (IdProduit)
     references Produit (IdProduit);

alter table type_de_categorie add constraint FKtyp_Cat_FK
     foreign key (IdCategorie)
     references Categorie (IdCategorie);


-- Index Section
-- _____________ 

create unique index ID_Adresse_IND
     on Adresse (IdAdresse);

create unique index ID_Categorie_IND
     on Categorie (IdCategorie);

create unique index ID_Client_IND
     on Client (IdClient);

create index FKadresse_du_client_IND
     on Client (IdAdresse);

create unique index ID_Commande_IND
     on Commande (IdCommande);

create index FKreception_de_la_commande_IND
     on Commande (idVendeur);

create index FKEnvoit_des_commandes_IND
     on Commande (idFournis);

create unique index ID_Facture_IND
     on Facture (IdFacture);

create index FKajout_du_client__IND
     on Facture (IdClient);

create index FKajout_de_l_adresse_du_client_IND
     on Facture (IdAdresse);

create unique index ID_Fournisseur_IND
     on Fournisseur (idFournis);

create index FKadresse_du_fournisseur_IND
     on Fournisseur (IdAdresse);

create unique index ID_Produit_IND
     on Produit (IdProduit);

create unique index ID_Ajout_d_un_produit_IND
     on Ajout_d_un_produit (IdProduit, IdTypeproduit);

create index FKAjo_Typ_IND
     on Ajout_d_un_produit (IdTypeproduit);

create unique index ID_ajout_du_produit_en_facture_IND
     on ajout_du_produit_en_facture (IdFacture, IdProduit);

create index FKajo_Pro_IND
     on ajout_du_produit_en_facture (IdProduit);

create unique index ID_quantite1_IND
     on quantite1 (IdProduit, IdCommande);

create index FKqua_Com_IND
     on quantite1 (IdCommande);

create unique index ID_type_de_categorie_IND
     on type_de_categorie (IdProduit, IdCategorie);

create index FKtyp_Cat_IND
     on type_de_categorie (IdCategorie);

create unique index ID_TypeProduit_IND
     on TypeProduit (IdTypeproduit);

create unique index ID_Vendeur_IND
     on Vendeur (idVendeur);

