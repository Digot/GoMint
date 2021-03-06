/*
 * Copyright (c) 2015, GoMint, BlackyPaw and geNAZt
 *
 * This code is licensed under the BSD license found in the
 * LICENSE file in the root directory of this source tree.
 */

package io.gomint.server.config;

import com.blackypaw.simpleconfig.SimpleConfig;
import com.blackypaw.simpleconfig.annotation.Comment;

import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Global configuration for the whole GoMint Server.
 *
 * @author BlackyPaw
 * @author geNAZt
 * @version 1.0
 */
@NoArgsConstructor
@Getter
public class ServerConfig extends SimpleConfig {

	// ------------------------ General
	@Comment( "The host and port to bind the server to" )
	private ListenerConfig listener = new ListenerConfig();

	@Comment( "The maximum number of players to play on this server" )
    private int maxPlayers = 10;

	// ------------------------ Packet Dumping
	@Comment( "Enables packet dumping for development purposes; not to be used for production" )
    private boolean enablePacketDumping = false;

	@Comment( "The directory to save packet dumps into if packet dumping is enabled" )
    private String dumpDirectory = "dumps";

	// ------------------------ World
	@Comment( "Name of the world to load on startup" )
	private String world = "world";

	@Comment("Amount of Chunks which will always be loaded and stay loaded around the spawn area.\n" +
	         "You can set this to 0 if you don't want to hold any Chunks in Memory but this also means\n" +
	         "that you have to load the Chunks from disk everytime someone joins and the Chunk GC has cleared\n" +
	         "the chunks. USE 0 WITH CAUTION!!! If the JVM gets out of memory, chunks get removed out of the Cache\n" +
             "to give memory back to the JVM to not crash. You _can_ run GoMint on ~4MB (tested) with a viewDistance of 4\n" +
             "and this set to 8. But be sure that everything that has todo with chunks (even setting or getting blocks) will\n" +
             "cause GoMint to load Chunks from Disc and save them directly after that.")
	private int amountOfChunksForSpawnArea = 16;

    @Comment("View distance of a player. This defines the amount of chunks sent to a player when he moves or spawns.\n" +
             "This is measured in Chunks." )
    private int viewDistance = 6;

    @Comment("After how many seconds should a chunk be marked to be gced after the last player left the chunk.")
    private int secondsUntilGCAfterLastPlayerLeft = 10;

    @Comment("Amount of seconds to wait after the chunk has come into the cache before we can select it for gc.")
    private int waitAfterLoadForGCSeconds = 30;

    // ------------------------ Advanced Performance Settings
    @Comment( "Amount of Ticks per second which should be used to drive this server." )
    private int targetTPS = 64;

}
