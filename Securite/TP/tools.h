
#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <openssl/aes.h>
#include <openssl/des.h>
#include <openssl/evp.h>
#include <openssl/rand.h>

/**
 * Crée un vecteur d'initialisation (sel)
 * @param initiaisationVector : le vecteur cible
 * @param chl_size : le nb d'octets
 */
void generateSalt(unsigned char *initialisationVector ,int chl_size);

/**
 * Fonction qui chiffre ou déchiffre en utilisant : 
 * @param key_data : le password
 * @param infile : le fichier source
 * @param outfile : le fichier cible
 * @param do_encrypt : 1 pour chiffrer, 0 pour dechiffrer
 */
int do_crypt (char *key_data,char *infile, char *outfile, int do_encrypt);
