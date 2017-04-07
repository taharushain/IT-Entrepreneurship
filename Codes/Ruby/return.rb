def add(one, two)
	one + two
end


def divide(one, two)
	return "I don't think so" if two == 0

	one/two
end


puts add(2,2)
puts divide(2,0)
puts divide(12,4)

