/*
 * Copyright (c) 2015, GoMint, BlackyPaw and geNAZt
 *
 * This code is licensed under the BSD license found in the
 * LICENSE file in the root directory of this source tree.
 */

package io.gomint.server.network;

/**
 * @author BlackyPaw
 * @version 1.0
 */
public enum PlayerConnectionState {

	/**
	 * The player is still waiting for the login packet.
	 */
	HANDSHAKE,

	/**
	 * The player has logged in and is preparing for playing.
	 */
	LOGIN,

	/**
	 * The player is entirely connected and is playing on the server.
	 */
	PLAYING;

}
