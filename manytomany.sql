SELECT pizzas.id,
pizzas.name,
sauces.name as sauce_name,
tp.name as pizza_topping
 FROM general.pizzas
INNER JOIN general.sauces
	ON general.pizzas.sauce=general.sauces.id
LEFT JOIN general.pizza_topping AS pt
ON general.pizzas.id=general.pt.pizza_id
Right JOIN general.toppings AS tp
ON tp.id=pt.topping_id
WHERE pizzas.id IS NOT null
AND pizzas.id=3;