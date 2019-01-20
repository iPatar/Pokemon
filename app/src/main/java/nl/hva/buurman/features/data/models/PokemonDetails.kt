package nl.hva.buurman.features.data.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class PokemonDetails(val id: String,
                     val name: String,
                     val base_experience: String,
                     val height: String,
                     val order: String,
                     val weight: String,
                     val moves: List<MoveDetail>) : Parcelable

@Parcelize
class MoveDetail(val move: Move,
                 val version_group_details: List<VersionGroupDetail>) : Parcelable

@Parcelize
class Move(val name: String,
           val url: String) : Parcelable

@Parcelize
class VersionGroupDetail(val level_learned_at: String,
                         val move_learn_method: MoveLearnMethod,
                         val version_group: VersionGroup) : Parcelable

@Parcelize
class MoveLearnMethod(val name: String,
                      val url: String) : Parcelable

@Parcelize
class VersionGroup(val name: String,
                   val url: String) : Parcelable