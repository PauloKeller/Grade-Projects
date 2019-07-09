const GraphQL = require('graphql')
const _ = require('lodash');

// Models
const Shop = require('../models/Shop')
const Menu = require('../models/Menu')
const Waiter = require('../models/Waiter')
const Dish = require('../models/Dish')
const Drink = require('../models/Drink')
const Dessert = require('../models/Dessert')
const Client = require('../models/Client')
const Address = require('../models/Address')
const Rating = require('../models/Rating')
const Order = require('../models/Order')
const Attendance = require('../models/Attendance')



const { 
    GraphQLObjectType, 
    GraphQLString, 
    GraphQLID, 
    GraphQLList,
    GraphQLInt, 
    GraphQLSchema,
    GraphQLNonNull,
    GraphQLFloat } = GraphQL

const ShopType = new GraphQLObjectType({
    name: 'Shop',
    fields: () => ({
        id: { type: GraphQLID },
        name: { type: GraphQLString },
        menu: { 
            type: MenuType,
            resolve(parent, args) {
                return Menu.findById(parent.menuId)
            }
        },
        waiters: {
            type: new GraphQLList(WaiterType),
            resolve(parent, args) {
                return Waiter.find({ shopId: parent.id })
            }
        },
        ratings: {
            type: new GraphQLList(RatingType),
            resolve(parent, args) {
                return Rating.find({ shopId: parent.id })
            }
        }
    })
})

const MenuType = new GraphQLObjectType({
    name: 'Menu',
    fields: () => ({
        id: { type: GraphQLID },
        name: { type: GraphQLString },
        rating: { type: GraphQLInt },
        dishes: {
            type: new GraphQLList(DishType),
            resolve(parent, args) {
                return Dish.find({ menuId: parent.id })
            }
        },
        drinks: {
            type: new GraphQLList(DrinkType),
            resolve(parent, args) {
                return Drink.find({ menuId: parent.id })
            }
        },
        desserts: {
            type: new GraphQLList(DessertType),
            resolve(parent, args) {
                return Dessert.find({ menuId: parent.id })
            }
        },
        shops: { 
            type: new GraphQLList(ShopType),
            resolve(parent, args) {
                return Shop.find({ menuId: parent.id })
            }
        }
    })
})

const WaiterType = new GraphQLObjectType({
    name: 'Waiter',
    fields: () => ({
        id: { type: GraphQLID },
        name: { type: GraphQLString },
        rating: { type: GraphQLInt },
        shop: { 
            type: ShopType,
            resolve(parent, args) {
                return Shop.findById(parent.shopId)
            }
        }
    })
})

const DishType = new GraphQLObjectType({
    name: 'Dish',
    fields: () => ({
        id: { type: GraphQLID },
        name: { type: GraphQLString },
        rating: { type: GraphQLInt },
        menu: { 
            type: MenuType,
            resolve(parent, args) {
                return Menu.findById(parent.menuId)
            } 
        }
    })
})

const DrinkType = new GraphQLObjectType({
    name: 'Drink',
    fields: () => ({
        id: { type: GraphQLID },
        name: { type: GraphQLString },
        rating: { type: GraphQLInt },
        menu: { 
            type: MenuType,
            resolve(parent, args) {
                return Menu.findById(parent.menuId)
            } 
        }
    })
})

const DessertType = new GraphQLObjectType({
    name: 'Dessert',
    fields: () => ({
        id: { type: GraphQLID },
        name: { type: GraphQLString },
        rating: { type: GraphQLInt },
        menu: { 
            type: MenuType,
            resolve(parent, args) {
                return Menu.findById(parent.menuId)
            }
        },
    })
})

const ClientType = new GraphQLObjectType({
    name: 'Client',
    fields: () => ({
        id: { type: GraphQLID },
        name: { type: GraphQLString },
        email: { type: GraphQLString },
        phone: { type: GraphQLString },
        address: { 
            type: AddressType,
            resolve(parent, args) {
                return Address.findById(parent.addressId)
            } 
        },
        ratings: { 
            type: new GraphQLList(RatingType),
            resolve(parent, args) {
                return Rating.find({ clientId: parent.id })
            }
        }
    })
})

const AddressType = new GraphQLObjectType({
    name: 'Address',
    fields: () => ({
        id: { type: GraphQLID },
        cep: { type: GraphQLString },
        state: { type: GraphQLString },
        city: { type: GraphQLString },
        district: { type: GraphQLString },
        street: { type: GraphQLString },
        number: { type: GraphQLInt }
    })
})

const RatingType = new GraphQLObjectType({
    name: 'Rating',
    fields: () => ({
        id: { type: GraphQLID },
        shop: { 
            type: ShopType,
            resolve(parent, args) {
                return Shop.findById(parent.shopId)
            }
        },
        client: { 
            type: ClientType,
            resolve(parent, args) {
                return Client.findById(parent.clientId)
            }
        },
        order: { 
            type: OrderType,
            resolve(parent, args) {
                return Order.findById(parent.orderId)
            }
        },
        attendance: { 
            type: AttendanceType,
            resolve(parent, args) {
                return Attendance.findById(parent.attendanceId)
            }
        },
    })
})

const OrderType = new GraphQLObjectType({
    name: 'Order',
    fields: () => ({
        id: { type: GraphQLID },
        dish: { 
            type: DishType,
            resolve(parent, args) {
                return Dish.findById(parent.dishId)
            }
        },
        drink: { 
            type: DrinkType,
            resolve(parent, args) {
                return Drink.findById(parent.drinkId)
            }
        },
        dessert: { 
            type: DessertType,
            resolve(parent, args) {
                return Dessert.findById(parent.dessertId)
            }
        },
    })
})

const AttendanceType = new GraphQLObjectType({
    name: 'Attendance',
    fields: () => ({
        id: { type: GraphQLID },
        waiter: { 
            type: WaiterType,
            resolve(parent, args) {
                return Waiter.findById(parent.waiterId)
            }
        },
        placeRating: { type: GraphQLString },
        waitingTimeRating: { type: GraphQLFloat },
    })
})

const RootQuery = new GraphQLObjectType({
    name: 'RootQueryType',
    fields: {
        shop: {
            type: ShopType,
            args: { id: { type: GraphQLID }},
            resolve(parent, args){
                return Shop.findById(args.id)
            }
        },
        menu: {
            type: MenuType,
            args: { id: { type: GraphQLID }},
            resolve(parent, args) {
                return Menu.findById(args.id)
            }
        },
        shops: {
            type: new GraphQLList(ShopType),
            resolve(parent, args) {
                return Shop.find()
            }
        },
        menus: {
            type: new GraphQLList(MenuType),
            resolve(parent, args) {
                return Menu.find()
            }
        },
        waiter: {
            type: WaiterType,
            args: { id: { type: GraphQLID }},
            resolve(parent, args) {
                return Waiter.findById(args.id)
            }
        },
        waiters: {
            type: new GraphQLList(WaiterType),
            resolve(parent, args) {
                return Waiter.find()
            }
        },
        dish: {
            type: DishType,
            args: { id: { type: GraphQLID }},
            resolve(parent, args) {
                return Dish.findById(args.id)
            }
        },
        dishes: {
            type: new GraphQLList(DishType),
            resolve(parent, args) {
                return Dish.find()
            }
        },
        drink: {
            type: DrinkType,
            args: { id: { type: GraphQLID }},
            resolve(parent, args) {
                return Drink.findById(args.id)
            }
        },
        drinks: {
            type: new GraphQLList(DrinkType),
            resolve(parent, args) {
                return Drink.find()
            }
        },
        dessert: {
            type: DessertType,
            args: { id: { type: GraphQLID }},
            resolve(parent, args) {
                return Dessert.findById(args.id)
            }
        },
        desserts: {
            type: new GraphQLList(DessertType),
            resolve(parent, args) {
                return Dessert.find()
            }
        },
        client: {
            type: ClientType,
            args: { id: { type: GraphQLID }},
            resolve(parent, args) {
                return Client.findById(args.id)
            }
        },
        clients: {
            type: new GraphQLList(ClientType),
            resolve(parent, args) {
                return Client.find()
            }
        },
        address: {
            type: AddressType,
            args: { id: { type: GraphQLID }},
            resolve(parent, args) {
                return Address.findById(args.id)
            }
        },
        addresses: {
            type: new GraphQLList(AddressType),
            resolve(parent, args) {
                return Address.find()
            }
        },
        rating: {
            type: RatingType,
            args: { id: { type: GraphQLID }},
            resolve(parent, args) {
                return Rating.findById(args.id)
            }
        },
        ratings: {
            type: new GraphQLList(RatingType),
            resolve(parent, args) {
                return Rating.find()
            }
        },
        order: {
            type: OrderType,
            args: { id: { type: GraphQLID }},
            resolve(parent, args) {
                return Order.findById(args.id)
            }
        },
        orders: {
            type: new GraphQLList(OrderType),
            resolve(parent, args) {
                return Order.find()
            }
        },
        attendance: {
            type: AttendanceType,
            args: { id: { type: GraphQLID }},
            resolve(parent, args) {
                return Attendance.findById(args.id)
            }
        },
        attendances: {
            type: new GraphQLList(AttendanceType),
            resolve(parent, args) {
                return Attendance.find()
            }
        }
    }
})

const Mutation = new GraphQLObjectType({
    name: 'Mutation',
    fields: {
        addShop: {
            type: ShopType,
            args: {
                name: { type: new GraphQLNonNull(GraphQLString) },
                menuId: { type: new GraphQLNonNull(GraphQLID) }
            },
            resolve(parent, args){
                let shop = new Shop({
                    name: args.name,
                    menuId: args.menuId
                })
                return shop.save()
            }
        },
        addMenu: {
            type: MenuType,
            args: {
                name: { type: new GraphQLNonNull(GraphQLString) },
                rating: { type: new GraphQLNonNull(GraphQLInt) }
            },
            resolve(parent, args) {
                let menu = new Menu({
                    name: args.name,
                    rating: args.rating
                })
                return menu.save()
            }
        },
        addWaiter: {
            type: WaiterType,
            args: {
                name: { type: new GraphQLNonNull(GraphQLString) },
                rating: { type: new GraphQLNonNull(GraphQLInt) },
                shopId: { type: new GraphQLNonNull(GraphQLID) },
            },
            resolve(parent, args) {
                let waiter = new Waiter({
                    name: args.name,
                    rating: args.rating,
                    shopId: args.shopId
                })
                return waiter.save()
            }
        },
        addDish: {
            type: DishType,
            args: {
                name: { type: new GraphQLNonNull(GraphQLString) },
                rating: { type: new GraphQLNonNull(GraphQLInt) },
                menuId: { type: new GraphQLNonNull(GraphQLID) }
            },
            resolve(parent, args) {
                let dish = new Dish({
                    name: args.name,
                    rating: args.rating,
                    menuId: args.menuId
                })
                return dish.save()
            }
        },
        addDrink: {
            type: DrinkType,
            args: {
                name: { type: new GraphQLNonNull(GraphQLString) },
                rating: { type: new GraphQLNonNull(GraphQLInt) },
                menuId: { type: new GraphQLNonNull(GraphQLID) }
            },
            resolve(parent, args) {
                let drink = new Drink({
                    name: args.name,
                    rating: args.rating,
                    menuId: args.menuId
                })
                return drink.save()
            }
        },
        addDessert: {
            type: DessertType,
            args: {
                name: { type: new GraphQLNonNull(GraphQLString) },
                rating: { type: new GraphQLNonNull(GraphQLInt) },
                menuId: { type: new GraphQLNonNull(GraphQLID) }
            },
            resolve(parent, args) {
                let dessert = new Dessert({
                    name: args.name,
                    rating: args.rating,
                    menuId: args.menuId
                })
                return dessert.save()
            }
        },
        addClient: {
            type: ClientType,
            args: {
                name: { type: new GraphQLNonNull(GraphQLString) },
                email: { type: new GraphQLNonNull(GraphQLString) },
                phone: { type: new GraphQLNonNull(GraphQLString) },
                addressId: { type: new GraphQLNonNull(GraphQLID) }
            },
            resolve(parent, args) {
                let client = new Client({
                    name: args.name,
                    email: args.email,
                    phone: args.phone,
                    addressId: args.addressId
                })
                return client.save()
            }
        },
        addAddress: {
            type: AddressType,
            args: {
                cep: { type: new GraphQLNonNull(GraphQLString) },
                state: { type: new GraphQLNonNull(GraphQLString) },
                city: { type: new GraphQLNonNull(GraphQLString) },
                district: { type: new GraphQLNonNull(GraphQLString) },
                street: { type: new GraphQLNonNull(GraphQLString) },
                number: { type: new GraphQLNonNull(GraphQLInt) },
            },
            resolve(parent, args) {
                let address = new Address({
                    cep: args.cep,
                    state: args.state,
                    city: args.city,
                    district: args.district,
                    street: args.street,
                    number: args.number,
                })
                return address.save()
            }
        },
        addRating: {
            type: RatingType,
            args: {
                shopId: { type: new GraphQLNonNull(GraphQLID) },
                clientId: { type: new GraphQLNonNull(GraphQLID) },
                orderId: { type: new GraphQLNonNull(GraphQLID) },
                attendanceId: { type: new GraphQLNonNull(GraphQLID) },
            },
            resolve(parent, args) {
                let rating = new Rating({
                    shopId: args.shopId,
                    clientId: args.clientId,
                    orderId: args.orderId,
                    attendanceId: args.attendanceId,
                })
                return rating.save()
            }
        },
        addOrder: {
            type: OrderType,
            args: {
                dishId: { type: new GraphQLNonNull(GraphQLID) },
                drinkId: { type: new GraphQLNonNull(GraphQLID) },
                dessertId: { type: new GraphQLNonNull(GraphQLID) },
            },
            resolve(parent, args) {
                let order = new Order({
                    dishId: args.dishId,
                    drinkId: args.drinkId,
                    dessertId: args.dessertId,
                })
                return order.save()
            }
        },
        addAttendance: {
            type: AttendanceType,
            args: {
                waiterId: { type: new GraphQLNonNull(GraphQLID) },
                placeRating: { type: new GraphQLNonNull(GraphQLString) },
                waitingTimeRating: { type: new GraphQLNonNull(GraphQLFloat) },
            },
            resolve(parent, args) {
                let attendance = new Attendance({
                    waiterId: args.waiterId,
                    placeRating: args.placeRating,
                    waitingTimeRating: args.waitingTimeRating,
                })
                return attendance.save()
            }
        },
    }
})

module.exports = new GraphQLSchema({
    query: RootQuery,
    mutation: Mutation
})
