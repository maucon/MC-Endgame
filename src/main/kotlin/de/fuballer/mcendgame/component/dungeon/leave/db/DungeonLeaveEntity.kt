package de.fuballer.mcendgame.component.dungeon.leave.db

import de.fuballer.mcendgame.domain.Portal
import de.fuballer.mcendgame.framework.stereotype.Entity
import org.bukkit.Location

data class DungeonLeaveEntity(
    override var id: String,

    var portals: MutableList<Portal>,
    var leaveLocation: Location
) : Entity<String>
