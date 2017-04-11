class Team 
	include Enumerable

	attr_accessor :name, :players

	def initialize(name)
		@name = name
		@players = []
	end

	def add_players(*players)
		@players+= players
	end

	def to_s
		"Team: #{@name} Players: #{@players.join(", ")}"
	end

	def each
		@players.each { |player| yield player}
	end
end


