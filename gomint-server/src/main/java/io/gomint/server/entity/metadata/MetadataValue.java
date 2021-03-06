/*
 * Copyright (c) 2015, GoMint, BlackyPaw and geNAZt
 *
 * This code is licensed under the BSD license found in the
 * LICENSE file in the root directory of this source tree.
 */

package io.gomint.server.entity.metadata;

import io.gomint.jraknet.PacketBuffer;

/**
 * @author BlackyPaw
 * @version 1.0
 */
public abstract class MetadataValue {

	/**
	 * Serializes this metadata value into the given packet buffer.
	 *
	 * @param buffer The buffer to serialize into
	 * @param index The index of this metadata value
	 */
	void serialize( PacketBuffer buffer, int index ) {
		byte flags = (byte) ( ( this.getTypeId() << 5 ) | index );
		buffer.writeByte( flags );
	}

	/**
	 * Deserializes this metadata value from the given packet buffer.
	 *
	 * @param buffer The buffer to deserialize from
	 */
	void deserialize( PacketBuffer buffer ) {

	}

	/**
	 * Gets the ID of the metadata value's type as used for encoding / decoding.
	 *
	 * @return The ID of the metadata value's type
	 */
	abstract byte getTypeId();

}