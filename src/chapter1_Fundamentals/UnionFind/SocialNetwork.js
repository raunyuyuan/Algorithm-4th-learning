// socialNetWrok.js
// n 个成员
// m 个已经排序的时间戳，每个时间戳包含哪两个成员已经成为朋友的关系
// 设计查找所有成员最早联系在一起的时间

function SocialNetwork(persons) {
  const relations = []

  function findPersonId(p) {
    return persons.findIndex(person => p === person)
  }

  function bindFriendship(p1, p2) {
    let id1 = findPersonId(p1)
    let id2 = findPersonId(p2)
    if (relations[id1] == null) relations[id1] = id1
    if (relations[id2] == null) relations[id2] = relations[id1];
    else {
      const id = relations[id2]
      for (let i = 0; i < relations.length; i++) {
        if (relations[i] === id) {
          relations[i] = relations[id1]
        }
      }
    }
  }

  function isFriend(p1, p2) {
    const id1 = findPersonId(p1)
    const id2 = findPersonId(p2)
    return relations[id1] === relations[id2]
  }

  function isAllFriend() {
    if (relations.length !== persons.length) return false
    for (let i = 1; i < relations.length; i++) {
      if (relations[i] !== relations[i - 1]) {
        return false
      }
    }
    return true
  }
  return {
    isFriend,
    bindFriendship,
    findPersonId,
    isAllFriend,
    relations
  }
}

const persons = new Array(20).fill(null).map((_, idx) => idx)



const timeStamps = new Array(100).fill(null).map((item, idx) => {
  let p1 = Math.floor(Math.random() * 20)
  let p2 = Math.floor(Math.random() * 20)
  while(p1 === p2) {
    p2 = Math.floor(Math.random() * 20)
  }
  return {
    time: idx,
    p1,
    p2
  }
})
console.log(persons, timeStamps)

function findTimeAllPersonsAreFriends(persons, timeStamps) {
  const socialNetwork = SocialNetwork(persons)
  for (let i = 0; i < timeStamps.length; i++) {
    const timeStamp = timeStamps[i]
    socialNetwork.bindFriendship(timeStamp.p1, timeStamp.p2)
    if (socialNetwork.isAllFriend()) {
      console.log(socialNetwork.relations)
      return timeStamp.time
    }
  }
  console.log(socialNetwork.relations)
  return null
}

console.log('All Persons are friends at this time:', findTimeAllPersonsAreFriends(persons, timeStamps))



