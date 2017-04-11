require_relative 'player'
require_relative 'team'

player1 = Player.new("Bob", 12, 14)
player2 = Player.new("Tom", 32, 11)
player3 = Player.new("Jim", 22, 17) 
player4 = Player.new("Jerry", 15, 14) 
player5 = Player.new("Johny", 17, 18) 

red_team = Team.new("Red")
red_team.add_players(player1,player2,player3, player4, player5)


elig_players = red_team.select {|player| (14..20) === player.age} 

p elig_players[0].name
p elig_players[1].name


aft_rej_players = red_team.reject {|player| (14..20)=== player.age}

p aft_rej_players[0].name
p aft_rej_players[1].name
p aft_rej_players[2].name