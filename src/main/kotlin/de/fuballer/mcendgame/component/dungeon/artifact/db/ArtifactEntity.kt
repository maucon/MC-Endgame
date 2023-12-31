package de.fuballer.mcendgame.component.dungeon.artifact.db

import de.fuballer.mcendgame.component.dungeon.artifact.data.Artifact
import de.fuballer.mcendgame.framework.stereotype.Entity
import java.util.*

data class ArtifactEntity(
    override var id: UUID,

    var artifacts: MutableList<Artifact> = mutableListOf()
) : Entity<UUID>
