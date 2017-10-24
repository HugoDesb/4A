//#include <openssl/aes.h>
#include <stdio.h>
#include <stdlib.h>


FILE * encrypt(FILE * plainFile, int blockSize) {
	//Split file into chunks
	//Generate key
	//Create an Initial Vector aka "salt"
	
}

char* getBlockFromFile(FILE *fp, int blockNumber, int blockSize)
{
	
	// lseek to seek_offset

	len = blockSize / 8;
	bit_pos = blockSize % 8;

	for (i = 0; i<len; i++) {
		copy_from_file_to_local_buffer_byte_by_byte();
	}

	if (bit_pos) {
		byte[i] <<= (8 - bit_pos);
		append_byte_to_local_buffer();
	}

	return local_buffer;
}
