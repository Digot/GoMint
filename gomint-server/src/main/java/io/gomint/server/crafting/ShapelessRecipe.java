/*
 * Copyright (c) 2015, GoMint, BlackyPaw and geNAZt
 *
 * This code is licensed under the BSD license found in the
 * LICENSE file in the root directory of this source tree.
 */

package io.gomint.server.crafting;

import io.gomint.inventory.ItemStack;
import io.gomint.jraknet.PacketBuffer;
import io.gomint.server.util.PacketDataOutputStream;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

/**
 * Resembles a shapeless crafting recipe, i.e. a recipe for which the
 * arrangement of its ingredients does not matter. All that counts is
 * that all ingredients and no more items are put into the crafting
 * container.
 *
 * @author BlackyPaw
 * @version 1.0
 */
public class ShapelessRecipe extends CraftingRecipe {

	private ItemStack[] ingredients;
	private ItemStack[]   outcome;

	public ShapelessRecipe( ItemStack[] ingredients, ItemStack[] outcome, UUID uuid ) {
		super( outcome, uuid );
		this.ingredients = ingredients;
		this.outcome = outcome;
	}

	@Override
	public Collection<ItemStack> getIngredients() {
		return Arrays.asList( this.ingredients );
	}

	@Override
	public void serialize( PacketBuffer buffer, PacketDataOutputStream intermediate ) throws IOException {
		intermediate.writeInt( this.ingredients.length );
		for ( int i = 0; i < this.ingredients.length; ++i ) {
			intermediate.writeItemStack( this.ingredients[i] );
		}
		intermediate.writeInt( this.outcome.length );
		for ( int i = 0; i < this.outcome.length; ++i ) {
			intermediate.writeItemStack( this.outcome[i] );
		}
		intermediate.writeUUID( this.getUUID() );

		byte[] recipeData = intermediate.toByteArray();
		buffer.writeInt( 0 );
		buffer.writeInt( recipeData.length );
		buffer.writeBytes( recipeData );
	}

	/*                      Left in here for later reference
	@Override
	public boolean applies( CraftingContainer container, boolean consume ) {
		long[] matches = new long[this.ingredients.length];
		Arrays.fill( matches, -1L );
		int numStacks = 0;

		for ( int j = 0; j < container.getHeight(); ++j ) {
			for ( int i = 0; i < container.getWidth(); ++i ) {
				ItemStack found = container.getCraftingSlot( i, j );

				if ( found != null ) {
					++numStacks;
					if ( numStacks > this.ingredients.length ) {
						// Does not apply -> too many item stacks
						return false;
					}

					// Check if this item stack matches any ingredient:
					for ( int k = 0; k < this.ingredients.length; ++k ) {
						if ( matches[k] != -1L ) {
							continue;
						}

						ItemStack required = this.ingredients[k];
						if ( required.getId() == found.getId() &&
						     required.getAmount() <= found.getAmount() &&
						     ( required.getData() == (short) 0xFFFF || required.getData() == found.getData() ) ) {
							matches[k] = ( (long) j << 32 | i );
						}
					}
				}
			}
		}

		for ( int i = 0; i < this.ingredients.length; ++i ) {
			if ( matches[i] == -1L ) {
				return false;
			}

			if ( consume ) {
				int x = (int) matches[i];
				int y = (int) ( matches[i] >>> 32 );

				// Consume item:
				ItemStack found = container.getCraftingSlot( x, y );
				found.setAmount( found.getAmount() - this.ingredients[i].getAmount() );
				if ( found.getAmount() <= 0 ) {
					// Clear out slot:
					container.setCraftingSlot( x, y, null );
				}
			}
		}
		return true;
	}
	*/
}
