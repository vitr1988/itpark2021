Примеры запросов для mongodb:

show dbs

db.genre.find()

db.genre.find({"name": /вы/})

db.genre.find().sort({ name: 1 }).limit( 4 ) /* сортировка в asc 1, desc -1 */

db.genre.insertOne({
_id: 'tes',
name: 'Тестовый'
})

db.genre.updateOne(
{ "name" : "Тестовый2" },
{ $set: { name: "Тестовый" }, $unset: {status: null} }
)

db.genre.deleteOne(
{ "name" : "Тестовый" }
)




show dbs;