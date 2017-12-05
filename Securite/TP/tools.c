#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <openssl/aes.h>
#include <openssl/des.h>
#include <openssl/evp.h>
#include <openssl/rand.h>
#include "tools.h"

/**
 * Crée un vecteur d'initialisation (sel)
 * @param initiaisationVector : le vecteur cible
 * @param chl_size : le nb d'octets
 */
void generateSalt(unsigned char *salt ,int chl_size){
 
    int r = 0;
 
    r = RAND_bytes(salt,chl_size);
 
    if (!r) {
        printf("\nInternal error !\n");
        exit(EXIT_FAILURE);
    }
}

/**
 * Fonction qui chiffre ou déchiffre en utilisant : 
 * @param key_data : le password
 * @param infile : le fichier source
 * @param outfile : le fichier cible
 * @param do_encrypt : 1 pour chiffrer, 0 pour dechiffrer
 */
int do_crypt (char *key_data,char *infile, char *outfile, int do_encrypt)
{
  
  /* Allow enough space in output buffer for additional block */
  unsigned char inbuf[1024], outbuf[1024 + EVP_MAX_BLOCK_LENGTH],
    key[32], iv[16], salt[8];
  
  int key_data_len = strlen(key_data), nrounds = 1, inlen, outlen;
  
  FILE *in = fopen(infile,"rb");
  FILE *out = fopen(outfile,"wb");
  
  if(do_encrypt){ //if encryption case
    generateSalt(salt,8);
    fwrite(salt, 1, 8, out);
  }
  else{ //if decryption case
    fread(salt, 1, 8, in);
  }
  
  //derivate key & iv from the supplied password
  EVP_BytesToKey(EVP_aes_256_cbc(), EVP_md5(), salt, (unsigned char*)key_data, key_data_len, nrounds, key, iv);
  
  EVP_CIPHER_CTX ctx;
  EVP_CIPHER_CTX_init(&ctx);
  EVP_CipherInit_ex(&ctx, EVP_aes_256_cbc(), NULL, key, iv, do_encrypt);
  
  for(;;){
    inlen = fread(inbuf, 1, 1024, in);
    if(inlen <= 0) break;
    if(!EVP_CipherUpdate(&ctx, outbuf, &outlen, inbuf, inlen)){
      /* Error */
      EVP_CIPHER_CTX_cleanup(&ctx);
      return 0;
    }
    fwrite(outbuf, 1, outlen, out);
  }

  //dernier bloc
  if(!EVP_CipherFinal_ex(&ctx, outbuf, &outlen)){
    /* Error */
    EVP_CIPHER_CTX_cleanup(&ctx);
    return 0;
  }
  
  fwrite(outbuf, 1, outlen, out);
  EVP_CIPHER_CTX_cleanup(&ctx);
  
  fclose(in);
  fclose(out);
  
  return 1;
}
