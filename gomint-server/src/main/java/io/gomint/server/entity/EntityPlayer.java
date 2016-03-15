/*
 * Copyright (c) 2015, GoMint, BlackyPaw and geNAZt
 *
 * This code is licensed under the BSD license found in the
 * LICENSE file in the root directory of this source tree.
 */

package io.gomint.server.entity;

import io.gomint.server.entity.metadata.MetadataContainer;
import io.gomint.server.network.PlayerConnection;
import io.gomint.server.world.WorldAdapter;

/**
 * @author BlackyPaw
 * @version 1.0
 */
public class EntityPlayer extends Entity {

	private final PlayerConnection connection;

	/**
	 * Constructs a new player entity which will be spawned inside the specified world.
	 *
	 * @param world The world the entity should spawn in
	 * @param connection The specific player connection associated with this entity
	 */
	public EntityPlayer( WorldAdapter world, PlayerConnection connection ) {
		super( EntityType.PLAYER, world );
		this.connection = connection;
	}

	/**
	 * Gets the connection associated with this player entity.
	 *
	 * @return The connection associated with this player entity
	 */
	public PlayerConnection getConnection() {
		return this.connection;
	}

	@Override
	public MetadataContainer getMetadata() {
		MetadataContainer metadata = super.getMetadata();
		metadata.putBoolean( 0, false );
		metadata.putShort( 1, (short) 0x2c01 );
		metadata.putString( 2, this.connection.getUsername() );
		metadata.putBoolean( 3, true );
		metadata.putBoolean( 4, false );
		metadata.putInt( 7, 0 );
		metadata.putBoolean( 8, false );
		metadata.putBoolean( 15, false );
		metadata.putBoolean( 16, false );
		metadata.putIntTriple( 17, 0, 0, 0 );
		return metadata;
	}

}