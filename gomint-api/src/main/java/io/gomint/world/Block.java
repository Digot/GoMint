/*
 * Copyright (c) 2015, GoMint, BlackyPaw and geNAZt
 *
 * This code is licensed under the BSD license found in the
 * LICENSE file in the root directory of this source tree.
 */

package io.gomint.world;

/**
 * @author geNAZt
 * @author BlackyPaw
 * @version 1.0
 */
public interface Block {

	/**
     * Gets the complete ID (range 0 - 4095) of the block.
     *
     * @return The ID of the block
     */
    int getBlockId();

	/**
     * Gets the data value of the block (0 - 15).
     *
     * @return The data value of the block
     */
    byte getBlockData();

	/**
     * Sets the complete ID of the block. Any values that are out of the supported ID range (0 - 4095) will be
     * set to 0 (Air).
     *
     * @param id The ID of the block
     */
    void setBlockId( int id );

	/**
     * Sets the data value of the block. Any values that are out of the supported ID range (0 - 15) will be
     * set to 0 (no data).
     *
     * @param data The data value of the block
     */
    void setBlockData( byte data );

}
