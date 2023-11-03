package com.example.comusenias.data.repositories

import android.net.Uri
import com.example.comusenias.constants.FirebaseConstants
import com.example.comusenias.domain.models.response.Response
import com.example.comusenias.domain.models.users.ChildrenModel
import com.example.comusenias.domain.models.users.SpecialistModel
import com.example.comusenias.domain.repositories.SpecialistRepository
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.storage.StorageReference
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.tasks.await
import java.io.File
import javax.inject.Inject
import javax.inject.Named

class SpecialistRepositoryImpl @Inject constructor(
    @Named(FirebaseConstants.SPECIALIST_COLLECTION) private val specialistRef: CollectionReference,
    @Named(FirebaseConstants.SPECIALIST_COLLECTION) private val storageSpecialistRef: StorageReference,
    @Named(FirebaseConstants.CHILDREN_COLLECTION) private val childrenRef: CollectionReference
) : SpecialistRepository {


    override suspend fun saveImageUserSpecialist(file: File): Response<String> {
        return try {
            val fromFile = Uri.fromFile(file)
            val ref = storageSpecialistRef.child(file.name)
            val uploadTask = ref.putFile(fromFile).await()
            val url = ref.downloadUrl.await()
            return Response.Success(url.toString())
        } catch (e: Exception) {
            e.printStackTrace()
            Response.Error(e)
        }
    }

    override suspend fun createUserSpecialist(user: SpecialistModel): Response<Boolean> {
        return try {
            specialistRef.document(user.id).set(user).await()
            Response.Success(true)
        } catch (e: Exception) {
            e.printStackTrace()
            Response.Error(e)
        }
    }

    override fun getUserSpecialistById(id: String): Flow<SpecialistModel> = callbackFlow {
        val snapshotListener = specialistRef.document(id).addSnapshotListener { snapshot, _ ->
            val user = snapshot?.toObject(SpecialistModel::class.java) ?: SpecialistModel()
            trySend(user)
        }
        awaitClose {
            snapshotListener.remove()
        }
    }

    override suspend fun updateUserSpecialist(user: SpecialistModel): Response<Boolean> {
        return try {
            val mapImage: MutableMap<String, Any> = HashMap()
            mapImage["name"] = user.name
            mapImage["image"] = user.image?.let { it } ?: ""
            mapImage["date"] = user.date
            mapImage["tel"] = user.tel
            specialistRef.document(user.id).update(mapImage).await()
            Response.Success(true)
        } catch (e: Exception) {
            e.printStackTrace()
            Response.Error(e)
        }
    }

    override suspend fun getChildrenForSpecialistById(id: String): Flow<List<ChildrenModel>> =
        callbackFlow {
            val snapshotListener = childrenRef.whereEqualTo("idSpecialist", id)
                .addSnapshotListener { snapshot, _ ->
                    val childrenModelList = snapshot?.toObjects(ChildrenModel::class.java)
                        ?: ArrayList<ChildrenModel>()
                    trySend(childrenModelList)
                }
            awaitClose {
                snapshotListener.remove()
            }
        }

}